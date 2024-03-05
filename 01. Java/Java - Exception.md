# Java - Exception

- 어떤 원인에 의해 오동작 하거나 비 정상적 종료되는 경우
- null 객체를 사용하거나 0으로 나누거나…
- **Error** 와는 다르다!
    - 프로그램으로 잘못 작성한 경우
    - 메모리 부족, Stack Overflow 등등…
- Java 자체에서 자체적으로 예외를 처리 하지 않고 프로그래머에게 알려 프로그래머가 적절한 처리 코드를 처리하는 것이 목적
    
    

### Checked Exception

- 예외에 대한 대처가 없으면 컴파일을 진행시키지 않음
- `non-RuntimeException`
    - `IOException` , `SQLExcpetion`

### Unchecked Exception

- 예외에 대한 대처 코드가 없더라도 컴파일은 진행됨
- 예를들어 배열의 범위를 넘어서는 `OutOfBound` 같은 경우
- `RuntimeException` 이라고 불림
    - `NullPointException` , `ArrayIndexOutOfBoundsException`

### try - catch - finally

- try 블록에서 예외 발생시 JVM이 Exception 클래스 생성 후 던짐(throws)
- 던져진 excpetion을 처리 할 수 있는 catch 블록에서 받은 후에 처리
    - 이런 exception에서도 다형성이 사용된다!
    - 상위 타입의 exception이 먼저 사용되는 경우 뒤의 catch는 동작할 기회가 없다.
    - 그렇기에 catch는 **작은 범위에서 큰 범위** 로 정의한다! *sub → super*
    - 마찬가지로 throw 또한 **부모보다 큰 범위**는 정의 할 수 없다.
- *catch* 한 구문은 다시 돌아가지 않는다.
    
    ```jsx
    try {
    	test.add(1);
    	test.add(2);
    	test.add("뜬금없는 String"); //Exception
    	test.add(3); // unreachable Code
    } catch (무언가의Exception e) {
    	e.printStackTrace();
    }
    ```
    
    - 이런 코드는 test 할 때만 사용해야한다.
    - 예상 exception 코드는 마지막에 집어 넣는다.
- finally 부분은 catch에 잡히더라도 언제나 실행되고 끝난다.
- 하지만 finally를 사용시 코드가 더러워지는 경향이 있음
- *try-with-resoures* 를 사용한다면 자동으로 close 처리
    - `try (FileInputStream fileInput = new FileInputStream(”abc.txt”);`
    - 자동으로 close 된다.

### Exception 메서드

- `getMessage()` : String
    - 발생한 예외에 대한 예외 메세지
- `printStackTrace()` : void
    - 예외 발생한 트래킹의 정보를 출력
    - debug시에 사용 편리
    - 배포 기간에 제거해야할 불편함
    - 로깅 관련 Framework를 이용해서 해결
    - 보안상 이슈가 있을 수 있음을 명심할 것

### 사용자 정의 exception

- 규칙
    - `extends Exception`
    - `suer("예외메세지")`
    - `class`
- 형식
    - `throw new 예외 클래스 이름([params]);`
- 목적
    - 사용자가 정의한 예외를 명시적으로 발생시켜야 하는 경우
    - 개발 중에 예외 처리에 대한 테스트를 위해 명시적으로 발생시키는 경우