# Rest API

> 일반적인 OPEN API와 함께 사용되는 공공 데이터에서 사용되는 Interface
> 

### Rest

- 하나의 URI는 하나의 고유한 리소스를 대표하도록 설계된다는 개념에 전송방식의 결합
- HTTP URI를 통해 제어할 자원의 명시, Method를 통해 해당 자원의 제어
- 어떤 환경에서 요청을 하던 (Web이라던가, Mobile) 해당 구조의 View를 신경 쓸 필요가 없이 데이터를 전달해줄 수 있다.

![Untitled](resources/restimg/Untitled.png)

### REST 구성

- **자원** - URI
- **행위** - HTTP Method
- **표현**

### HTTP Method 관련 어노테이션

![Untitled](resources/restimg/Untitled%201.png)

### Get

- 자원 받아오기
- 멱등성 (자원 상태 변경 없음)

### POST

- 새로운 자원 추가
- 서버의 상태를 변경
- 여러 자원 수행
- 201이 정상 코드

### PUT

- 존재하는 자원의 변경
- 존재하지 않다면 새로운 자원 생성
- 단일 자원 수행
- 201 정상 코드

### DELETE

- 자원 삭제
- 먹등성

### PATCh

- 한 자원의 데이터를 부분적 변경
- PUT과 다른 점은 존재하는 자원의 부분적 업데이트

### REST Annotation

![Untitled](resources/restimg/Untitled%202.png)

## 실습

- 매개변수를 JSON 데이터로 받는 `@RequestBody`

```jsx
	@PostMapping(value = "/user")
	public ResponseEntity<?> userRegister(@RequestBody MemberDto memberDto) {
		logger.debug("userRegister memberDto : {}", memberDto);
		try {
			memberService.joinMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//			return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
```

##