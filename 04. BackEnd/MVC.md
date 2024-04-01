# MVC

- model2 구조라고도 불림

### Model

- service, dao, java beans
- Logic을 처리하는 모든 것
- controller로 부터 넘어온 data를 이용하여 이를 수행하고 그에 대한 결과를 다시 controller에 return한다.

### View

- JSP
- 모든 화면 처리를 담당
- client 요청, controller 요청 모두 jsp에서 처리
- Logic 처리를 위한 java code는 사라지고 결과 출력을 위한 code만 존재

### Controller

- Logic처리를 위한 Model단을 호출
- return 받은 결과 data를 필요에 따라 request, session등에 저장
- 이걸 바탕으로 redirect나 forward로 view에 출력 위임

## MVC 구조

![Untitled](resources/MVC%207cf650400f58455693db0bd110b45cc2/Untitled.png)

## 장점

- JSP 코드의 간단화
- 분업 용이, 유지 보수 용이
- 확장성 증가

## 단점

- 비용증가
- 배우기 어려움
