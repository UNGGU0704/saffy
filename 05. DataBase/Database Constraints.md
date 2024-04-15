# Database

## 테이블 제약조건

- **Not Null 조건 :**
    - 컬럼을 필수 필드화 시킬 떄 사용
- **UNIQUE 조건**
    - 데이터의 유일성을 보장하고 자동으로 인덱스 생성
    - null은 허용 되지만 primary key는 null 허용안함
- **check 조건**
    - 컬럼의 값을 특정 범위 내로 제한
- **DEFAULT 조건**
    - 기본으로 입력되는 값
- **PRIMARY KEY**
    - UNIQUE + NOT NULL 결합
    - 참조 무결성을 가진다