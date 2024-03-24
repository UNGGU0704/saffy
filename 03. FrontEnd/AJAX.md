# AJAX (24. 03. 12)

- 언어나 프레임워크가 아닌 구현하는 방식
- 화면을 갱신하지 않고 데이터를 서버로부터 가져와 처리 하는 방식
- 비동기 방식으로 결과를 조회
- 일반 요청과는 달리 화면 전환 없이 동적으로 재구성

### 서버와 클라이언트의 상호 작용

- 웹 화면 구성방식은 서버 중심과 클라이언트 중심으로 구분
- 화면 구성이 서버에서 이루어진다. → **SSR**
- 화면 구성이 클라이언트(웹 브라우저)에서 이루어진다. → **CSR**
- AJAX는 CSR 방식이다.

![Untitled](resources/AJAX%20(24%2003%2012)%20a81cf237a85d483880690ccc3414c09c/Untitled.png)

## fetch()

- 브라우저에서 fetch() 함수를 지원하기 이전에는 `XMLHttpRequest` 를 직접 이용하여 HTTP 요청하고 응답을 구현
- 첫번째 인자로 URL, 두번째 인자로 options 객체를 받음
    - 디폴트 options는 get이다.
- 실행 결과로 Promise 타입의 객체를 반환
- **사용법**
    
    ```sql
    response.text() - 응답을 읽고 text를 반환
    response.json() - 응답을 JSON 형식으로 파싱 함 
    response.formData() - 응답을 FormData 객체 형태로 반환
    response.blob() - 응답을 Blob 형태로 반환 
    ```