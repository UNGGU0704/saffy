# IoC & Container

## IoC

- 제어의 역행
- 객체 간의 연결 관계를 런타임에 결정
- 객체간의 느슨한 연결
- IoC의 구현 방법 중 하나가 **DI**
- 객체 생성을 Container에게 위임 처리

### IoC 유형

![Untitled](resources/iocimg/Untitled.png)

- **Dependency Lookup**
    - Connection 생성할 때 사용 한 경험
    - Lookup한 Object 타입을 Castring 필요
- **Dependency Injection**
    - Object가 컨테이너의 존재 여부를 알 필요가 없음
    - Lookup이 필요 없음
    - Setter 주입과 Constructror 주입

## Container

- 객체의 사용 소멸, 라이플 사이클 담당
- 어플리케이션의 주요 기능을 제공
- thread 관리

### Spring DI Container

- Sprind DI가 관리하는 객체 → Bean
    - 이런 Bean을 관리하는 객체를 BeanFactory라고 한다.
    - 다른 컨테이너 기능을 추가해 ApplicationContext라 한다.
    
    ![Untitled](resources/iocimg/Untitled%201.png)
    
- `ApplicationContext`→ `BeanFactory`
    - `BeanFactory`을 관리하는 `ApplicationContext`
    - Bean을 생성하는 `BeanFactory`
- 일반적으로`**ApplicationContext`** 를 주로 사용한다.

## IoC 개념

### 개체간 강한 결합

- 클래스 호출 방식
- 클래스의 한 사항이 변경되면 다른  Class도 변경해야함 → 의존 관계가 높다

![Untitled](resources/iocimg/Untitled%202.png)

*이걸 낮출려면…?*

### Interface를 사용하여 결합도 낮추기

- 다형성을 이용해 변화가능
- 인터페이스를 활용해 직접적인 의존성을 제거

![Untitled](resources/iocimg/Untitled%203.png)

*더 낮출 수 있을까?*

### 객체간의 강한 결합을 Factory를 통해 낮추기

- 팩토리가 객체를 생성
- 인터페이스 변경시 팩토리만 수정해야함

![Untitled](resources/iocimg/Untitled%204.png)

```jsx
	public static HelloMessage getHelloMessage(String lang) {
		if("kor".equals(lang)) {
			return new HelloMessageKor();
		} else if("eng".equals(lang)) {
			return new HelloMessageEng();
		} else {
			return null;
		}
	}
```

- 팩토리에서 적절한 클래스를 반환한다.
- 이 팩토리 적용한 것이 컨테이너의 기능
- 컨테이너의 기능을 제공해주는 것이 IoC 모듈

*더 낮추기!*

### Assembler를 통해 결합도 낮추기

- IoC 호출 방식
- 실행 시점에 클래스간의 관계를 형성
- 어떠한 것에도 의존하지 않은 형태

![Untitled](resources/iocimg/Untitled%205.png)

- `appcApplicationContext` 를 사용해서 beans를 정의
- 이것을 통해 원하는 객체를 받아올 수 있다.

```jsx
		public static void main(String[] args) {
			
			System.out.println("start");
			ApplicationContext appcApplicationContext = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/xml/applicationContext.xml");
			System.out.println("xml start");
			
			System.out.println("----------------------------------------");
			
			HelloMessage kor1 = appcApplicationContext.getBean("kor", HelloMessageKor.class);
			HelloMessage kor2 = appcApplicationContext.getBean("kor", HelloMessageKor.class);
			System.out.println(kor1 + " ::::: " + kor2);
		}
```

### xml를 활용한 DI

```jsx
<!-- 생성자를 이용한 bean 설정  -->
	<bean id = "action" class = "com.ssafy.ws.step2.Action"/>
	<bean id = "comic" class = "com.ssafy.ws.step2.Comic"/>	
	
	<bean id = "action2" class = "com.ssafy.ws.step2.Action" >
		<constructor-arg value = "a" index = "1"></constructor-arg>
		<constructor-arg value = "B" index = "0"></constructor-arg>
	</bean>
	
	<!-- property 지정한 di bean 설정 -->
	<bean id = "audience" class = "com.ssafy.ws.step2.Audience">
		<property name="movie" ref = "action"></property>
	</bean>
```

```jsx
ApplicationContext context = new GenericXmlApplicationContext("applicationConext.xml");
 
 Audience audience = context.getBean("audience", Audience.class);
 audience.watch();
```

- 각 객체가 생성되어 사용할 수 있다.’
- 단 각 객체의 getter와 setter가 생성되어야 한다.
    - 아마 setter로 property 를 주입하는게 아닌가 예측

### Annotation을 활용한 DI

> 멤버 변수에 직접 정의하여 setter method를 만들지 않아도 됨
> 
- `**@Autowired**`
    - spring에서만 사용가능
    - DI가 필요한 경우 유용
    - 생성자에 사용시 불별성이 유지되는 final 키워드에도 주입이 가능하다.
- **`@Inject`**
    - Framework에 종속적이지 않음

- 빈 객체의 생성 scope 범위는 아래와 같이 설정할 수 있다.

![Untitled](resources/iocimg/Untitled%206.png)

### 스프링 빈의 생명 주기

![Untitled](resources/iocimg/Untitled%207.png)