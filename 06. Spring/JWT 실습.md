# JWT 실습

## 최초 토큰 생성 및 로그인

```jsx
const userLogin = async (loginUser) => {
    await userConfirm(
      loginUser,
      (response) => {
        if (response.status === httpStatusCode.CREATE) {
          console.log("로그인 성공!!!!")
          let { data } = response
          let accessToken = data["access-token"]
          let refreshToken = data["refresh-token"]
          isLogin.value = true
          isLoginError.value = false
          isValidToken.value = true
          sessionStorage.setItem("accessToken", accessToken)
          sessionStorage.setItem("refreshToken", refreshToken)
        }
      },
      (error) => {
        console.log("로그인 실패!!!!")
        isLogin.value = false
        isLoginError.value = true
        isValidToken.value = false
        console.error(error)
      }
    )
  }
  
  async function userConfirm(param, success, fail) {
  await local.post(`/user/login`, param).then(success).catch(fail);
}
```

- vue.js에서 로직 상으로 userLogin 호출
- 백엔드에 로그인 로직 처리

```jsx
	@Operation(summary = "로그인", description = "아이디와 비밀번호를 이용하여 로그인 처리.")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @Parameter(description = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MemberDto memberDto) {
		log.debug("login user : {}", memberDto);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			MemberDto loginUser = memberService.login(memberDto);
			if(loginUser != null) {
				String accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
				String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
				log.debug("access token : {}", accessToken);
				log.debug("refresh token : {}", refreshToken);
				
//				발급받은 refresh token 을 DB에 저장.
				memberService.saveRefreshToken(loginUser.getUserId(), refreshToken);
				
//				JSON 으로 token 전달.
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				
				status = HttpStatus.CREATED;
			} else {
				resultMap.put("message", "아이디 또는 패스워드를 확인해 주세요.");
				status = HttpStatus.UNAUTHORIZED;
			} 
			
		} catch (Exception e) {
			log.debug("로그인 에러 발생 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
```

- 토큰 생성
- 토큰을 DB에 저장한다.
- 프론트에 전달한 Map 자료구조를 선언하고 토큰과 메세지를 저장해서 리턴한다.

```jsx
        if (response.status === httpStatusCode.CREATE) {
          console.log("로그인 성공!!!!")
          let { data } = response
          let accessToken = data["access-token"]
          let refreshToken = data["refresh-token"]
```

- Front에 저장 성공

### 로그인 체크

```jsx
const onlyAuthUser = async (to, from, next) => {
  const memberStore = useMemberStore();
  const { userInfo, isValidToken } = storeToRefs(memberStore);
  const { getUserInfo } = memberStore;

  let token = sessionStorage.getItem("accessToken");

  if (userInfo.value != null && token) {
    await getUserInfo(token);
  }
  if (!isValidToken.value || userInfo.value === null) {
    next({ name: "user-login" });
  } else {
    next();
  }
};
```

```jsx
  // memberStore의 getUserInfo 
  
  const getUserInfo = async (token) => {
    let decodeToken = jwtDecode(token)
    console.log(decodeToken)
    await findById(
      decodeToken.userId,
      (response) => {
        if (response.status === httpStatusCode.OK) {
          userInfo.value = response.data.userInfo
        } else {
          console.log("유저 정보 없음!!!!")
        }
      },
      async (error) => {
        console.error(
          "g[토큰 만료되어 사용 불가능.] : ",
          error.response.status,
          error.response.statusText
        )
        isValidToken.value = false

        await tokenRegenerate()
      }
    )
  }
```

- onlyAuthUser에서 memberStore의 getUserInfo를 가져온다.
- findById()에서 유효성을 검증하고 User 정보를 얻는다
    - 이건 백엔드에서 처리
    
    ```jsx
    	@Operation(summary = "회원인증", description = "회원 정보를 담은 Token 을 반환한다.")
    	@GetMapping("/info/{userId}")
    	public ResponseEntity<Map<String, Object>> getInfo(
    			@PathVariable("userId") @Parameter(description = "인증할 회원의 아이디.", required = true) String userId,
    			HttpServletRequest request) {
    //		logger.debug("userId : {} ", userId);
    		Map<String, Object> resultMap = new HashMap<>();
    		HttpStatus status = HttpStatus.ACCEPTED;
    		if (jwtUtil.checkToken(request.getHeader("Authorization"))) {
    			log.info("사용 가능한 토큰!!!");
    			try {
    //				로그인 사용자 정보.
    				MemberDto memberDto = memberService.userInfo(userId);
    				resultMap.put("userInfo", memberDto);
    				status = HttpStatus.OK;
    			} catch (Exception e) {
    				log.error("정보조회 실패 : {}", e);
    				resultMap.put("message", e.getMessage());
    				status = HttpStatus.INTERNAL_SERVER_ERROR;
    			}
    		} else {
    			log.error("사용 불가능 토큰!!!");
    			status = HttpStatus.UNAUTHORIZED;
    		}
    		return new ResponseEntity<Map<String, Object>>(resultMap, status);
    	}
    ```
    
    - 토큰의 유효성 검증
    - 토큰의 유효성 검증 함수 ***checkToken()***
    
    ```jsx
    //	전달 받은 토큰이 제대로 생성된 것인지 확인 하고 문제가 있다면 UnauthorizedException 발생.
    	public boolean checkToken(String token) {
    		try {
    //			Json Web Signature? 서버에서 인증을 근거로 인증 정보를 서버의 private key 서명 한것을 토큰화 한것
    //			setSigningKey : JWS 서명 검증을 위한  secret key 세팅
    //			parseClaimsJws : 파싱하여 원본 jws 만들기
    			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(token);
    //			Claims 는 Map 구현체 형태
    			log.debug("claims: {}", claims);
    			return true;
    		} catch (Exception e) {
    			log.error(e.getMessage());
    			return false;
    		}
    	}
    ```
    

## 로그인

```jsx
const onlyAuthUser = async (to, from, next) => {
  const memberStore = useMemberStore();
  const { userInfo, isValidToken } = storeToRefs(memberStore);
  const { getUserInfo } = memberStore;

  let token = sessionStorage.getItem("accessToken");

  if (userInfo.value != null && token) {
    await getUserInfo(token);
  }
  if (!isValidToken.value || userInfo.value === null) {
    next({ name: "user-login" });
  } else {
    next();
  }
};
```

- getUserInfo()

```jsx
  const getUserInfo = async (token) => {
    let decodeToken = jwtDecode(token)
    console.log(decodeToken)
    await findById(
      decodeToken.userId,
      (response) => {
        if (response.status === httpStatusCode.OK) {
          userInfo.value = response.data.userInfo
        } else {
          console.log("유저 정보 없음!!!!")
        }
      },
      async (error) => {
        console.error(
          "g[토큰 만료되어 사용 불가능.] : ",
          error.response.status,
          error.response.statusText
        )
        isValidToken.value = false

        await tokenRegenerate() //토큰 재 발급
      }
    )
  }
```

- 백엔드에서 검증을 실시한다.
```
	@Operation(summary = "회원인증", description = "회원 정보를 담은 Token 을 반환한다.")
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") @Parameter(description = "인증할 회원의 아이디.", required = true) String userId,
			HttpServletRequest request) {
//		logger.debug("userId : {} ", userId);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtUtil.checkToken(request.getHeader("Authorization"))) {
			log.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				MemberDto memberDto = memberService.userInfo(userId);
				resultMap.put("userInfo", memberDto);
				status = HttpStatus.OK;
			} catch (Exception e) {
				log.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			log.error("사용 불가능 토큰!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
```
