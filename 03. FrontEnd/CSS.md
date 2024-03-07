# CSS (24. 03. 06)

- HTML문서를 화면에 표시하는 방식을 정의한 언어
- 어떤 Style을 적용 하느냐에 따라 하나의 구조를 전혀 다른 페이지 처럼 표현 함
- **선택자** 와 **선언** 두부분으로 구성
    - **선택자** : 규칙이 적용되는 엘리먼트
    - **선언** : 선택자에 적용될 스타일을 작성
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled.png)
    

## 스타일 시트

### 외부 스타일 시트

- `<link>` 를 사용하여 외부 스타일 시트를 적용
    - <head>안에 작성 하여 적용한다.
    - css 파일 경로를 의미한다.
    - import를 통해서 외부 스타일 시트를 적용 가능하다.

### 내부 스타일 시트

- `<head>` tag 내부에 작성
- 외부 스타일 시트보다 우선 적용된다.
- tag 내부에 CSS 규칙을 작성

### 인라인 스타일

- 개별 요소마다 스타일을 지정 → 유지 보수에 용이하지 않음

**스타일 적용 우선 순위**

> *important > 인라인 내부 스타일 > 내부 스타일  > 외부 스타일 > 웹 브라우저 기본 값 
같은 스타일 시에는 좀 더 상세한 스타일을 적용한다.*
> 

## 선택자

- HTML 문서에서 CSS 규칙 적용 타겟이 되는 다양한 종류의 CSS 선택자가 존재
- **일반 선택자**
    - 전체 선택자
    - 타입 선택자
    - 클래스 선택자
- **복합 선택자**
    - 자식 선택자
    - 하위 선택자
    - 인접 형태 선택자
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%201.png)
    

### 일반 선택자

- **전체 선택자** 사용법은 `* {}` 이다.
    - HTML 문서 내 모든 요소를 선택
    - 우선 순위 가장 낮음
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%202.png)
    
- **타입 선택자** 사용법은 `elementName {}` 이다.
    - 태그명을 적용해 스타일 적용 태그 선택
    - `,` 로 구분한다.
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%203.png)
    
- **클래스 선택자** 는 `class-name {}` 이다.
    - 클래스명은 공백 없이 사용한다.
    - 동일 클래스명 중복 가능
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%204.png)
    
- **ID 선택자** 는 `#id-name {}` 이다.
    - 동일 id 중복 불가
    - 일반 선택자 중 가장 우선 순위가 높다.
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%205.png)
    

### 복합 선택자

- **하위 선택자**
    - 사용법은 `element element {}` 이다.
    - 1단계와 2단계 하위요소에 모두 적용
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%206.png)
    
- **인접 형태 선택자**
    - `element + element {}` , `element ~ element {}`
    - 첫번째 요소만 선택     ,   모든 요소를 선택
- **가상 클래스 선택자**
    - `element : 가상 클래스 {}`
    - User Agent가 제공하는 가상의 클래스를 지정
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%207.png)
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%208.png)
    
    - 자식을 까지 적용이 가능하다.
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%209.png)
    

- **속성 선택자**
    - 특정한 속성을 가지거나 속성 값을 갖는 요소를 선택
    - 화면에 같은 분류의 많은 항목들을 일괄적으로 선택할 때 유용
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2010.png)
    

### CSS 규칙 적용 우선순위

- 같은 엘리먼트에 두 개 이상의 CSS 규칙이 적용된 경우
    - *마지막 규칙 > 구제적인 규칙 > limportant가 우선 적용*

## CSS 속성

### Font 속성

- CSS property로 대체 가능함
- text의 글꼴, 굵기, 크기, 스타일을 지정

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2011.png)

### Text 속성

- 글자, 공간, 단어들이 보여지는 속성 다.

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2012.png)

### 사용자 인터페이스 속성

- 화면에 출력될 디자인 요소를 추가
- 배경, 이미지 변경

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2013.png)

### 테이블 & 테두리 속성

- table 과 관련된 엘리먼트에 관한 속성
- 테두리 너비, 스타일 등을 지정

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2014.png)

## Box Model

- CSS 모든 엘리먼트는 여려 겹의 상자로 둘러 쌓여 있다고 가정
- 모든 HTML 요소는 사각형의 박스 모델이고 위 → 아래, 왼쪽 → 오른쪽으로 쌓인다.

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2015.png)

### box-sizing

- 모든 요소의 box-sizing은 기본 값 **content-box** 이다.

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2016.png)

### margin

- box의 마진영역 너비를 지정
    - 값이 여러 개라면 가장 가장자리에 있는 요소에만 적용시킨다.
    
    ![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2017.png)
    

## Positioning

- HTML 내 부분 문서의 위치를 지정하거나 객체의 보임과 안보임을 다룬다.
- 엘리먼트의 위치를 고정시키거나 브라우저 크기에 따라 이동하는 웹을 만들기 위함
- 정적 HTML을 js를 활용하여 동적으로 만들기 위한 기본적인 속성

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2018.png)

- **static** : 기본 값으로 상단과 좌측에서 거리를 지정하지 못함
- **relative** : HTML내에서의 top, left 거리를 지정
- **absolute** : 자신의 상위 box속에서 절대적 위치를 지정
- **fixed** : 스크롤이 일어나도 지정 위치

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2019.png)

### Flexbox

- element를 효율적으로 배치, 정렬, 분산 할 수 있는 1차원 레이아웃
- 요소의 크기와 순서를 유연하게 배치할 수 있음
- flexbox의 구성요소는 Flex Container와 복수의 Flex Item으로 구성
- Container는 Item을 감싸는 부모 요소이며, 각 Item을 정렬하기 위해서는 Container가 필수

![Untitled](CSS%20(24%2003%2006)%20bd82449b59e74be3af80ecd7919dc261/Untitled%2020.png)