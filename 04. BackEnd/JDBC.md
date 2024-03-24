# JDBC

## Transaction

- 데이터베이스의 상태를 변화시키는 일종의 작업 단위를 의미
- 커밋과 롤백을 활용해 실행 전 상태로 되돌리거나 코드를 실행함

## JDBC

- 자바 프로그래밍 언어로 만들어진 클래스와 인터페이스로 이루어진 API
- SQL문을 실행 할 수 있는 호출 인터페이스
- 자바가 DBMS에도 독립적으로 만들어주는 기능

![Untitled](resources/JDBC%200dc9b68a45554b8491fa802250a8274c/Untitled.png)

### API

- **Driver** : 드라이버에 대한 정보를 가지고 있다.
- **Connection** : DB에 대한 하나의 세션을 표현
    - 디폴트는 setAutoCommit(true)로 설정
- **Statement** : SQL문장을 실행 하고 그것에 대한 결과 값을 가져오기 위해 사용
- **PreparedStatement** : 동일한 SQL문장을 준비해놓고 여러번 사용하기 위해 사용
- **Stored Procedures** : 저장된 프로시저문을 호출

### JDBC 개발 순서

1. JDBC 드라이버 로딩 
2. DBMS와 연결
3. SQL 실행 준비
4. SQL 실행 (*CRUD*)
5. DBMS 연결 끊기

## JDBC 관련 Pattern Programming

1. DTO Pattern
    - DB 테이블을 모방한다.
2. DAO Pattertn
    - DB Access를 위한 기능
    - CRUD
    - Driver 로딩, DB 연결, 통로 개설, 자원해제
3. Factory Pattern
    - 필요한 기능을 제공 받아서 사용
    - Driver 로딩, DB 연결, 자원 해제
4. Singleton Pattern
    - 단일 instance