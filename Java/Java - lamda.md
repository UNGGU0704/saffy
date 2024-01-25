# Java - lamda

- 함수형 프로그래밍의 형태로 재사용 가능한 코드 블록
- 익명 이너 클래스를 이용한 처리 방식을 class 사용하지 않고 code block으로 전달

## 타겟 타입

- lamda식이 할당되는 인터페이스를 Lamda식의 타겟 타입이라 한다.
- 타겟 타입은 **abstract** 메서드가 반드시 하나만 존재해야한다.

### `@FunctionalInterface`

- 컴파일러에게 하나의 *abstract method* 만 있음을 체크
- 2개 있으면 inner class를 사용

## 람다식 장/단점?

### 장점

- 코드 간결화 증가
- 병렬 프로그래밍 가능

### 단점

- 재사용 불가
- 남용시 가독성 떨어짐

## 람다식 문법

### 람다식 구현

- 익명 함수 만들기와 비슷
    - 매개변수를 이용한 실행문 구현
- 메서드 형식
    
    `[modifiers] Type Name(args) { };`
    
    ```jsx
    int max(int a, int b) {
    	return a > b ? a : b;
    }
    
    // 람다 전환
    
    (a, b) - > a > b ? a : b;
    ```
    

### 람다 실습

```jsx
void print(String msg) {
 System.out.println(msg);
}

=
(msg) -> System.out.println(msg);

int min(int a, in b) {
 return a < b ? a : b;
}

=
(a, b) -> a < b ? a : b;

int printScore(String name, int score) {
 System.out.println(name + “:” + score);
}

=
(name, score) -> System.out.println(name + ":" + score);

int square(int x) {
 return x * x;
}

= 
x -> x * x;

int lottoNo() {
 return Math.random(45)+1;
}

=
() -> Math.random(45) + 1;
```