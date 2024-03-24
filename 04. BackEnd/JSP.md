# JSP

### JSP 동작 흐름

![Untitled](resources/JSP%20dd26f44c7fd74d45bc6a3f9b48e7fe39/Untitled.png)

## JSP 스크립트 요소

### 선언문

멤버 변수 선언이나 메소드를 선언하는 영역 

```sql
<%! 멤버변수와 method작성 %>

<%!
String name;

public void init() {}
%>
```

### 스크립트릿

Servlet 변환시 servoce() method에 해당되는 영역

```sql
<% 
 (대충 java 코드)
 %>
```

### 표현식

데이터를 브라우저에 출력할 때 사용

```sql
안녕 <% = name %> !!!
```

## JSP 내장 객체

### request

- HTML 폼 요소의 선택 값 등 사용자 입력 정보를 읽어올 때 사용

### response

- 사용자 요청에 대한 응답을 처리하기 위해 사용

### pageContext

- 각종 기본 객체를 얻거나  forward 및 include 기능을 활용할 때 사용

### session

- 클라이언트에 대한 세션 정보를 처리하기 위해 사용

### application

- 웹 서버의 애플리케이션 처리와 관련된 정보를 레퍼런스 하기 위해 사용

## 기본 객체의 영역

### page

- 하나의 JSP 페이지를 처리할 때 사용되는 영역
- 하나의 클라이언트 요청에 대하여 하나의 JSP 페이지가 호출
- 단 한개의 page객체만 대응 → 페이지 벗어나면 사라진다.

### request

- 하나의 HTTP 요청 처리할 때 사용
- 웹 브라우저가 요청 할 때 객체 생성
- 응답이 끝나면 사라진다.
- servlet → JSP 에게 view 처리를 위임할 때 사용되는 객체

### session

- 하나의 웹 브라우저와 관련된 영역
- 같은 웹 브라우저 내 요청에서 session은 공유 된다.

### application

- 하나의 웹 어플리케이션과 관련된 영역
- 웹 어플리케이션 하나당 한 객체

이런 페이지간의 정보 주고받는 메서드 목록

![Untitled](resources/JSP%20dd26f44c7fd74d45bc6a3f9b48e7fe39/Untitled%201.png)

## foward()

- 대상 자원으로 제어를 넘김
- a.jsp 에서 foward() 요청시 b.jsp가 응답

## 페이지 이동 (forward vs redirect)

`forward(request, respnse)` , `sendRedirect(location)`

- sendRedirect는 location이 들어간다 vs forward는 path이다.
    - 즉 redirect는 어디던지 움직일 수 있다.
    - 반면에 forward는 동일 서버 내의 **경로**
- foward()는 빠르다! 하지만 redirect는 느리다.
- forward()는 request의`setAttribute(name, value)`를 통해 데이터를 전달 할 수 있다.
- redirect()는 data 저장이 불가능 하다.
    - 단 session이나 cookie를 사용한다면 가능할지도? → 자원의 낭비
- redirect()와 달리 하나의 HTTP 요청에 의해 웹 서버의 동작이 이루어진다.