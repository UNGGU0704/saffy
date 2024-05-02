# Spring HTTP

## Spring HTTP의 요청

### GET

- 메세지 바디 없이 URL의 쿼리 파라미터
- URL 다음에 *?*를 시작
- 추가 파라티너는 *&*로 구분

`**http://localhost:8080/request-param?username=hello&age=2**`

### POST

- HTML의 Form을 사용
- 바디에 쿼리 파라미터 형식으로 전달

### GET과 FORM의 차이?

- GET은 HTTP 메세지의 body를 사용하지 않는다.
    - 즉 Content-Type이 없다.
- POST 요청은 Form이기에 body를 사용한다.
    - 포함 데이터가 어떤 형식인지 Content-Type을 지정해줘야한다.

## HTTP 요청 관련 어노테이션

### `@RequestMapping`

> `@RequestMapping("/test")`
> 
- `/test` 호출이 오면 실행
- 배열로도 설정 가능

### `@RequestMapping(value = "test", method = RequestMethod.GET)`

- HTTP 메서드 미 지정시 무관하게 모두 호출
- 이렇게 적기 귀찮기에 스프링에서 제공하는 축약 어노테이션

```jsx
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PatchMapping
```

### `@RequestParam`

```jsx
@ResponseBody
@RequestMapping("/test")
public String requestParamTest(
        @RequestParam(required = true) String username,
        @RequestParam(required = false) Integer age) {
    log.info("username={}, age={}", username, age);
    return "ok";
}
```

- URI 뒤에 붙은 쿼리 파라미터 값을 받아올 때 사용
- **`required` 옵션**
    - 기본적으로 true
    - 필수 파라미터일 경우 400에러
    - false일 경우 생략 가능
    - 이름만 있고 값이 없다면 빈 문자로 인식
- **`defaultValue` 옵션**
    - 값이 없을 경우의 기보 옵션

### `@PathVariable`

```jsx
@ResponseBody
@GetMapping("/test/users/{userId}")
public String mappingPath(@PathVariable String userId) {
		 log.info("userId={}, orderId={}, userId);
		 return "ok";
}
```

- REST API에서 호출 시 사용
- URI의 식별자 값 받아올 때 사용
- `http://localhost:8080/mapping/users/unggu`  사용시
    - `userId = unggu`
- 여러개도 사용 가능

### `@ModelAttribute`

```jsx
@ResponseBody
@GetMapping("/model-attribute")
public String modelAttribute(@ModelAttribute HelloData helloData) {
    
    log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
    log.info("helloData={}", helloData);
 
    return "ok";
 
}
```

- 요청 파라미터를 받아서 필요한 객체를 자동 생성
- **작동과정**
    1. 객체를 생성
    2. `HelloData` 객체의 프로퍼티를 찾는다.
    3. `setter` 를 호출해 값을 바인딩 한다.

  

> ***프로퍼티란?** : 객체에 `setUsername()` 이 있다면 이 객체는 username이라는 프로퍼티를 가지고 있다고 할 수 있다.*
>