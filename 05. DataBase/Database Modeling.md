# Database Modeling

## 개념적 데이터베이스 모델링

![Untitled](resources/databasemodeling/Untitled.png)

### 개체

- 사용자와 관계가 있는 주요 객체
- 데이터로 관리되어야 할것
- ex) 학생, 직원

### 속성

- 저장할 필요가 있는 실체에 관한 정보
- 개체의 성질, 분류, 수량 등등…

### 식별자

- 기본키 : 개체를 구별하는 key
- 후보키 : 기본키가 될 수 있는 후보 속성
- 대체키 : 기본키가 되지 못한 후보키
- 복합키 : 둘 이상의 컬럼을 묶어서 식별자로 정의

### 관계

- 관계가 있는 두 실체를 연겨랗고 관계를 부여

![Untitled](resources/databasemodeling/Untitled%201.png)

- 이러한 관계에는 차수성이 있다.
  - 1 : 1, 1: N, N : N
- **1 : 1**
  ![Untitled](resources/databasemodeling/Untitled%202.png)
  - 하나의 학과에는 한명의 학과장만 존재한다.
- **1 : N**
  ![Untitled](resources/databasemodeling/Untitled%203.png)
  - 하나의 학과에는 여러 학생이 존재한다.
- **N : N**
  ![Untitled](resources/databasemodeling/Untitled%204.png)
  - 여러 과목은 여러 학생들과 관계를 맺는다.

## 논리적 데이터베이스 모델링

- 기본키와 후보키를 설정
  - 후보키는 nullable 하다
- 개념적 데이터베이스 모델에서 도출 된 개체를 관계 타입의 테이블로 정의

![Untitled](resources/databasemodeling/Untitled%205.png)

### 제 1 정규화

- 반복되는 그룹 속성을 제거한 뒤 기본 테이블에 기본키 추가해 새로운 테이블을 생성
  - 반복되는 그룹 속성이란 같은 성격과 내용의 컬림이 연속적으로 나타내는 컬럼
- 기존 테이블과 1:N 관계를 형성

![Untitled](resources/databasemodeling/Untitled%206.png)

- **문제** : 부수적인 데이터 저장하기 위해 앞의 기본 데이터가 중복됨
  - 만약 A라는 사람이 많은 주문을 할 경우 등급 변화시 모든 컬럼에 대해 등급을 변경해야함
- **제 1 정규화 적용**

![Untitled](resources/databasemodeling/Untitled%207.png)

- 주문번호와 상품 코드를 모두 사용해 복합 key로 사용
- 추후 등급 변경시 주문 테이블만 수정해서 처리 가능

### 제 2 정규화

- 복합 key에 전체적으로 의존하지 않은 속성 제거
- 복합키의 일부분에 의해 종속되는 **부분적 함수 종속관계**를 제거

![Untitled](resources/databasemodeling/Untitled%208.png)

- 상품명, 단위, 단가 컬럼은 복합키 전체에 의해 의존하지 않음 → **분리 가능!**
- **제 2 정규화 적용**

![Untitled](resources/databasemodeling/Untitled%209.png)

### 제 3 정규화

- 키본키에 의존하지 않고 일반 컬럼에 의존하는 컬럼을 제거
- **이행적 함수 종속관계를** 갖는 컬럼을 제거

![Untitled](resources/databasemodeling/Untitled%2010.png)

- 회원 번호가 회원명과 회원등급을 결정하고 있다. → 테이블 분리
- **제 3 정규화** 적용

![Untitled](resources/databasemodeling/Untitled%2011.png)
