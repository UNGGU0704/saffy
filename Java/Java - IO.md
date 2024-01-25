# Java - I/O

- I/O 데이터의 입력과 출력
- 데이터는 한쪽에서 주고 한쪽에서 받는 구조로 되어있음
    - 데이터의 입력과 출력의 끝단 : 노드(Node)
    - 두 노드를 연결하고 데이터를 전송 할 수 있는 개념 : 스트림(Stream)
    - 스트림 : 단뱡향 통신

### Node Stream의 종류

![Untitled](Java%20-%20I%20O%2073af76b9aa574d2db718c81ceeea2d43/Untitled.png)

하지만 이런 NodeStream은 실제로 잘 쓰이지 않는다.

## 보조 스트림

- 다른 스트림에 부가적인 기능을 제공하는 스트림
    - 문자 set 변환
    - Buffering
    - 객체 입출력
- 노드 스트림 + 부가 기능

### 스트림 체이닝

- 필요에 따라 여러 보조 스트림을 연결 가능
    - Node ↔ 보조 스트림1 ↔ 보조 스트림2 ↔ 보조 스트림3

### 보조 스트림의 종류

![Untitled](Java%20-%20I%20O%2073af76b9aa574d2db718c81ceeea2d43/Untitled%201.png)

### InputsteamReader & OutputStreamWriter

- byte 기반 스트림을 char 기반으로 변경해주는 스트림
    - 문자열 관리에 있어 byte 단위보단 char 단위가  유리
    - 자바의 입출력에 있어 성능이 좋다

### Bufferd

- 스트림의 입/출력 효율을 높이기 위해 버퍼를 사용하는 스트림
- `BufferdInputStream()` , `BufferedOutputStream()` , `BufferedReader` 등이 있음

## 직렬화(serialization)

- 객체를 파일등에 저장하거나 네트워크로 전송하기 위해 연속적인 데이터로 변환하는 것
- 반대의 경우는 역 직렬화

### 직렬화 되기 위한 조건

- Serializable 인터페이스를 구현 할 것
- 클래스의 모든 멤버가 Seriablizable 인터페이스를 구현해야함
    - `transient` 예약자 사용시 직렬화에서 제외할 정보
    - `static` 도 직렬화에서 제외된다.

### 객체 직렬화

- **serialVersionUID**
    - 클래스의 변경 여부를 파악하기 위한 유일 키
- 직렬화 할때의 UID와 역직렬화의 UID가 다를 경우 예외를 발생시키는 형식
    - 만약 UID가 다르면 *InvalidClassExcpetion* 초래
- 디폴트 적으로 만들어짐