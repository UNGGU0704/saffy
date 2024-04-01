# EL

### EL

- EL은 표현을 위한 언어 JSP 스크립트 표현식 `<% = % >`을 대신하여 고안된 언어

### EL 내장 객체

![Untitled](resources/EL%20771fd0c1b6934eb8b4f1756aeed02c3d/Untitled.png)

![Untitled](resources/EL%20771fd0c1b6934eb8b4f1756aeed02c3d/Untitled%201.png)

## EL 문법

- EL 에서는 Dot 표기법 외에 `[]` 연산자를 사용하여 객체의 값에 접근 할 수 있다.
- pageContext를 제외한 모든 EL 내장 객체는 Map
- `**${expr}`\*\*
- `[]` 연산자 안의 값이 문자열이라면 이건 key로도 사용 될 수 있다.

```jsx
기존의 Dot 표기법
${userinfo.name}

[] 연산자를 사용
${userinfo["name"]

String[] names = {"홍길동", "이순신", "임꺽정"};
request.setAttribute("userNames", names);

${userNames[0]} 이나 ${userNames["1"] 으로 사용

requset.setAttribute("ssafy.user", memberDto);

${requestScope["ssafy.user"].name}

```
