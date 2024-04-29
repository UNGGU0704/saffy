# Spring MVC

> 기존의 MVC + Spring FrameWork가 제공하는 MVC
> 

## MVC Pattern

- 확장성을 위해 Model, View, Controller 세가지 영역으로 분리
- 컴포넌트간의 결합성을 낮게 유지
- **Model**
    - 어플리케이션 상태의 캡슐화
    - 쿼리에 대한 응답
    - 변경을 View에 통지
- **View**
    - 모델을 화면에 시각적으로 표현
    - 모델에게 업데이트 요청
    - 컨트롤러가 View를 선택하도록 허용
- **Controller**
    - 어플리케이션의 행위 정의
    - 응답에 대한 View 선택

### Spring MVC 구성 요소

**DispatcherServlet**

- 모든 클라이언트의 요청을 받음
- Controller에게 클라이언트 요청을 전달 하고 Controller가 리턴 한 값을 View에게 전달

**HadlerMapping**

- 클라이언트의 요청 URL을 어떤 Controller가 처리할지를 결정
- 어떤 핸들러 객체를 사용할지 결정하는 개체, DispatcherServlet은 하나 이상의 핸들러 매핑을 가질 수 있음

**Controller**

- 클라이언트 요청을 처리

**ModelAndView**

- 데이터 및 화면에 대한 정보 보유

**ViewResolver**

- Controller가 리턴 한 뷰 이름을 기반으로 어떤 View를 보여줄지 결정

### Spring MVC 요청 흐름

![Untitled](resources/mvcimg/Untitled.png)

## Spring MVC 구현

### DispatcherServlet 설정

```jsx
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
```

- DispatcherServlet이 클라이언트의 요청을 받는다.

```jsx
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
```

- Context 설정 파일들을 로드하기위해 리스너를 설정한다.

```jsx
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring/root-context.xml</param-value>
	</context-param>
	
	<!-- 사용자가 필요하다면 추가 기능 -->
		<context-param>
		<param-name>myTitle</param-name>
		<param-value>Unggu</param-value>
	</context-param>
```

- 리스너 설정이 완료 되면 `root-context.xml` 을 읽고 공통적으로 사용되는 최상위 context 생성
- 사용자가 필요하다면 추가적으로 적을 수 있다.

### 컨트롤러 구현

```jsx
@Controller
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	//해당 로직을 처리할 컨트롤러를 표시 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "김규형");
		//클라이언트와 요청 처리후 model을 전달
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
}
```

- 어노테이션을 통해 로직을 처리할 컨트롤러를 설정한다.
- `<context:component-scan base-package=*"com.ssafy.hello"* />`
    - servlet-context.xml에 컨트롤러를 등록해줘야한다.
    - 이런 방식으로 하면 해당 패키지 안에 있는 모든 클래스는 `@Controller` 어노테이션을 통해 자동 스캔 된다.

### 컨트롤러 파라미터

![Untitled](resources/mvcimg/Untitled%201.png)

### View 설정

```jsx
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
```

- Controller가 응답한 것을 처리할 ViewResolver 설정

### View 지정

**ModelAndView**

- `mav.setViewName("hello")` 를 통해 View 이름을 명시적으로 지정한다.

![Untitled](resources/mvcimg/Untitled%202.png)

**View 자동 지정**

- mapping된 URL을 그대로 View로 사용이 가능하다. 단
    - return type이 Model이나 Map인 경우

![Untitled](resources/mvcimg/Untitled%203.png)

**redirect view**

- view이름에 *redirect:* 접두사를 활용한다.
    - `redirect:/article/list`

### Model 설정

- Map, Model, ModelMap을 통한 방식으로 설정한다.

**ModelAndView**

```jsx
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "김규형");
		
		modelAndView.setViewName("index");
		
		return modelAndView;
```

- Controller에서 처리결과를 보여줄 view와 view에 전달할 값을 저장하는 용도

## Spring Web Application 동작 원리

![Untitled](resources/mvcimg/Untitled%204.png)

### 스프링 MVC는 어떤 흐름으로 이루어지는가?

![제목 없는 다이어그램.jpg](resources/mvcimg/%25EC%25A0%259C%25EB%25AA%25A9_%25EC%2597%2586%25EB%258A%2594_%25EB%258B%25A4%25EC%259D%25B4%25EC%2596%25B4%25EA%25B7%25B8%25EB%259E%25A8.jpg)

### 초기 준비 작업

![Untitled](resources/mvcimg/Untitled%205.png)

1. 톰캣 구동시 `web.xml` 을 읽는다.
2. `web.xml` 에 등록되어 있는 **ContextLoaderListener, DispatcherServlet**를 생성한다.
3. **ContextLoaderListener**는 `root-context.xml` 을 읽는다.
4. `root-context.xml` 에 등록되어 있는 Spring Container를 생성 DAO와 Service, DB 객체들이 생성된다. ****
5. 이어서 생성된 **DispatcherServlet**는 FrontController의 역할을 수행한다.
6. **DispatcherServlet**는 `servlet-context.xml` 를 통해 서블릿을 생성하고 관리한다. 
    1. **ViewResolver** 또한 여기서 생성되어 사용된다.
7. 모든 컨테이너가 준비되고 클라이언트를 기다린다.

### 이러한 구조는 어떻게 사용자의 요청을 처리하는가?

![Untitled](resources/mvcimg/Untitled%206.png)

1. WAS에 request가 도착한다.
2. **Filter**는 모든 요청에 대해 요청의 응답성 또는 유효성을 검사한다.
3. **DispatcherServlet**에게 요청이 위임된다.
    1. **HandlerMapping**은 적절한 핸들러(컨트롤러)를 찾아 DispatcherServlet에게 전달
    2. **HandlerAdapther**는 핸들러에 맞는 컨트롤러를 실행 

![Untitled](resources/mvcimg/Untitled%207.png)

1. *preHandle()* 을 통해 컨트롤러 실행전 인터셉터가 실행된다. 
2. 요청을 받은 컨트롤러는 비즈니스 로직을 실행한다.
    1. AOP가 관여할 수 있다. 
    2. 필요하다며 DB작업을 수행한다.
3. *posthandle()* 을 통해 컨트롤러가 호출 되고 인터셉터가 한번 더 실행된다. 

![Untitled](resources/mvcimg/Untitled%208.png)

1. 컨트롤러의 최종 결과물을 **DispatcherServlet**에게 전달한다.
2. **ViewResolver**에게 위임하여 적절한 View를 반환한다.
3. *afterCompletion()* 을 통해 뷰가 반환 된 뒤에 한번 더 인터셉터가 실행된다. 

![Untitled](resources/mvcimg/Untitled%209.png)

1. **DispatcherServlet**은 View 파일을 받는다.
2. **fillter**를 거쳐 최종적으로 처리하고 사용자의 화면에 출력한다.