# AOP

> 기존의 OOP는 많은 중복된 코드를 양산하는 문제가 함유
> 

**AOP의 등장**

### AOP 개요

- 관심사의 분리
- 부가 기능을 Aspect라는 독특한 모듈 형태로 만들어 설계하고 개발하는 방법
- 핵심 기능과 부가 기능을 분리함으로써 객체 지향적인 가치를 지킬 수 있도록 도와주는 개념이기도 한다.

### AOP 적용 예

- 메소드 성능 검사 코드 → 매번 출력문이 아니라 코드 밖에서 테스트 한다.
- 트랜잭션 처리 → try - catch의 코드의 중복을 제거해준다.
- 예외 반환
- 아키텍쳐 검증
- 시간 체크
- 등등…

## AOP 구조

![Untitled](resources/aopimg/Untitled.png)

### 핵심 관심 사항

- `BackingService`
- `AccountService`
- `CustomerService`

### 공통 관심 사항

- `Security`
- `Trascation`
- `...`

## AOP 용어

- **Target**
    - 핵심 기능을 담고 있는 모듈로 target은 부가기능을 부여할 대상
- **Advice**
    - 어느 시정에서 Aspect를 적용할 것인지 정의
- **JoinPoint**
    - Aspect가 적용 될 수 있는 지점
- **PointCut**
    - 공통 관심 사항이 적용될 JoinPoint
    - Advice를 적용할 taget의 method를 선별하는 정규 표현식
- **Aspect**
    - 여러 객체에서 공통으로 적용되는 공통 관심 사항
    - AOP의 기본 모듈
    - Advice + Pointcut
    - 싱글톤
- **Advisor**
    - Advice + pointcut

- **Weaving**

### AOP를 적용하면?

![Untitled](resources/aopimg//Untitled%201.png)

- 기존의 하나의 Application에 모여있던 프로그램

![Untitled](resources/aopimg//Untitled%202.png)

- 모든 Target에 적용되게 하여 코드의 중복 줄이기

## Spring AOP

- Target 객체에 대한 Proxy 기반
- Proxy는 런타임에 생성

![Untitled](resources/aopimg//Untitled%203.png)

- Proxy가 호출을 가로 채 Adivce의 부가 기능 로직 실행 하고 Target에 전달
- 후처리 할 수 도 있다.
- 그림으로 표현하면?

![Untitled](resources/aopimg//Untitled%204.png)

### 예시

```jsx
	public void encode(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().toShortString();
		System.out.println("BoardCheckAdvice : " + name);
		
		Object[] args = joinPoint.getArgs();
		for(Object obj : args) { 
			if(obj instanceof BoardDto) {
				System.out.println("내용을 암호화하자!!!!");
				BoardDto boardDto = (BoardDto) obj;
				String content = boardDto.getContent();
				boardDto.setContent("암호화한 내용 ::: " + content);
			}
		}
	}
```

- 모든 문자열에 대해 인코드 할 필요가 있다.’
- 이걸 어떻게 모든 메서드에 적용시키지?

```jsx
	<!-- AOP 설정 -->
	<bean id="boardContentEncodeAdvice" class="com.ssafy.aop.step02.before.BoardContentEncodeAdvice"></bean>
	
	<!--  com.ssafy.board package안에 있는 Dao로 끝나는 모든 클래스의 모든 메소드에 적용 -->
	<aop:config>
		<aop:aspect id="beforeAspect" ref="boardContentEncodeAdvice">
			<aop:pointcut id="publicMethod" expression="execution(public * com.ssafy.board..*Dao.*(..))"/>
			<aop:before method="encode" pointcut-ref="publicMethod"/>
		</aop:aspect>
	</aop:config>
```

```jsx
	public void decode(JoinPoint joinPoint, Object returnObj) throws Throwable{
		System.out.println("HistoryAdvice : " + returnObj);
		System.out.println("목록의 내용을 복호화하자!!!");
		if(returnObj instanceof List) {
			List<BoardDto> list = (List)returnObj;
			for(BoardDto boardDto : list) {
				boardDto.setContent(boardDto.getContent().replace("암호화", "복호화"));
			}
		}
	}
```

- 사용자에게 보여주기 위해 target의 처리가 끝난 뒤에 복호화 시킬 필요가 있다.

```jsx
	<!-- AOP 설정 -->
	<bean id="boardContentDecodeAdvice" class="com.ssafy.aop.step03.after.returning.BoardContentDecodeAdvice"></bean>
	
	<!--  com.ssafy.board package안에 있는 Dao로 끝나는 모든 클래스의 모든 메소드에 적용 -->
	<aop:config>
		<aop:aspect id="afterAspect" ref="boardContentDecodeAdvice">
			<aop:pointcut id="publicMethod" expression="execution(public * com.ssafy.board..*Dao.*(..))"/>
			<!-- 메소드가 정상적으로 결과값을 리턴했을경우. -->
			<aop:after-returning method="decode" pointcut-ref="publicMethod" returning="returnObj"/>
		</aop:aspect>
	</aop:config>
```

### XML 기반 AOP 설정

```jsx
<aop:pointcut id="publicMethod" expression="execution(public * com.ssafy.board..*Dao.*(..))"/>
```

- `**pointcut**`
    - 조인 포인트에 대한 표현식 → 어떤 메서드에 AOP를 적용할 것인가?
- 그 외 AOP 설정 태그

![Untitled](resources/aopimg//Untitled%205.png)

```jsx
<aop:before method="encode" pointcut-ref="publicMethod"/>
<aop:after-returning method="decode" pointcut-ref = "publicMethod" returning = "returnObj"/>
```

- `aop:before` vs `aop:after-returning`
    - 메서드가 언제 시작할것인지?
- 그 외 Advice 설정 태그

![Untitled](resources/aopimg//Untitled%206.png)