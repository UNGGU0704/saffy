# Servlet (24. 03. 18)

### Servlet이란?

- 자바를 사용하여 웹페이지를 동적으로 생성하는 서버 측 프로그램

![Untitled](resources/Servlet%20(24%2003%2018)%2089aac47c2b3f42c8bddd2e4069b2a079/Untitled.png)

### Servlet 특징
- 클라이언트의 Request에 대해 동적으로 작동하는 웹 어플리케이션
- 기존의 정적 웹 프로그램을 보완 하여 동적 웹 기능 제공
- Java 스레드를 이용해 동작
- MVC에서 컨트롤러를 담당 

### Servlet 배포

- `web.xml` 에서 <servlet> 과 <servlet-mapping>을 설정한다.
    
    ```sql
     <servlet>
        <display-name>helloservlet</display-name>
        <servlet-name>helloservlet</servlet-name>
        <servlet-class>com.ssafy.basic.helloservlet</servlet-class>
      </servlet>
      <servlet-mapping>
        <servlet-name>helloservlet</servlet-name>
        <url-pattern>/helloservlet</url-pattern>
    ```
    

## CGI

- 동적 웹 어플리케이션 기술
- ASP, PHP, C++ 등…
    - 동적 웹, 특정 서버에 종속됨
    - 프로세스 단위: 서버 부하 가능
- **Servlet(JSP)**
    - Java 기술 : 자바의 특징 그대로 사용가능
    - in Processing : 먼저 메모리에 할당
    - Multi Thread 단위 : 서버 부하 감소
 
### 서블릿 Life Cycle
1. 서블릿 객체가 생성된다.
2. `init()` 메서드를 통한 Servlet 초기화 작업
3. `service()` 메서를 통한 브라우저 요청 처리
4. `doGet()`, `doGet()` 요청을 처리하는 메서드 호출
5. `destroy()` 를 통해 서블릿 제거 

## 서블릿은 어떻게 요청과 응답을 제어하는가?

- 클라이언트의 요청
- `HttpServletRequest` , `HttpServletResponse` 객체를 생성
- Web.xml이 어느 서블릿을 요청한 것인지 탐색
- 해당 서블릿의 `service()` 를 호출
- 동적 페이지 생성 후 `ServletResponse` 객체에 응답 전송
- 객체 소멸 

### HttpServlerRequest : 요청 데이터 추출

- **getParameter(”key”)** : String → 단일 입력 값
- **getParameterValues(”key”)** : String[] → 다중 입력 값
- **getpParameterMap()** : Map<String, String[]>
- **getParameterNames()** : Enumeration

### 웹 설정 데이터 scope

- 현재 페이지 : pageScope
- 요청 ~ 응답 : HttpServletRequest
- 로그인 ~ 로그아웃 : HttpSession
- 어플리케이션 구동 ~ 종료 : ServletContext

### 응답 페이지 이동 방법

- forward : 기존 요청, 응답 객체를 가지고 패이지 이동
- redirect : 새로운 요청 , 응답 객체를 생성해서 페이지 이동


## 서블릿 프로그래밍 작성 순서

1. `HttpServlet` 를 상속받는다.
2. 서비스 메서드를 재정의 한다.
    
    `service()` , `doGet()` , `doPost()`
    
3. `doGet()` / `doPost()`
    - 요청 객체에 대한 한글 인코딩 설정 (”utf-8”)
    - 요청 객체로 전달 받은 파라미터 요청 데이터 가져오기
    - Model 업무 처리 요청
    - 응답 위한 mime-type 및 한글 인코딩 설정
    - 응답 위한 출력 스트림 생성
    - 출력 스트림을 통해서 동적 html 코드 응답
