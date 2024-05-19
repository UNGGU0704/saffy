# Axios

> *브라우저와 node.js에서 사용할 수 있는 Promise 기반 HTTP 클라이언트 라이브러리*
> 

### Axios의 특징

- 브라우저를 통해 `XMLHttpRequest` 객체 실행
- XSS 공격 방어
- 요청 및 응답에 대한 interceptor 지원
- JSON 데이터 자동 변환

### fetch vs axios

![Untitled](img/axios/Untitled.png)

**install**

```jsx
npm install axios
```

### axios 대표 API

```jsx
axios({option})
```

- HTTP 요청에 대한 속성들을 option을 통해 직접 정의 가능
    - 요청 URL, 요청 방식, 데이터 유형 등등…

```jsx
axios.get("URL").then().catch()
```

- URL 주소에 대해 HTTP GET 요청을 보낸다.
- 서버에서 무언가 데이터가 응답되면 `then()` 안에 정의된 로직이 실행 단 오류가 발생하면 `catch()` 호출

```jsx
axios.post(”URL”).then().catch()
```

- POST 요청도 GET과 비슷하다.

## Axios Instance API

### GET 방식

![Untitled](img/axios/Untitled%201.png)

- 파라미터 데이터를 포함시켜 요청이 가능하다.

### POST 방식

![Untitled](img/axios/Untitled%202.png)

- 데이터를 Message Body에 포함시켜 전송
- get방식의 params 사용하는 경우와 비슷

## Interceptor

- then 또는 catch로 처리되기전에 요청과 응답 가로채기 가능
- request는 요청을 보내기 전에 작업
- response에서는 서버 응답 return 되기 전에 작업