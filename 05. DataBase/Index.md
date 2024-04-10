# Index

- 책의 목차와 비슷한 역할
- 데이터의 조회시 동작속도를 높여주는 자료구조
- MYI 별도의 파일에 인덱스 저장

### Index의 문제점

- 공간적인 소모량 증가
- 같은 단어가 중복시에 시간적 이득 감소
- 최초 index 제작에 소요
- 데이터 변경이 잦을 경우 오히려 성능 저하

## Index의 종류

### 클러스터형 인덱스

- 특정 나열된 데이터들을 일정 기준으로 정렬해 주는 인덱스
- 클러스터형 인덱스 생성 시 데이터 페이지 전체가 다시 정렬되어 저장됨
- 테이블당 하나 생성
- 보조 인덱스보다 빠르다.
- 데이터 수정에 있어서는 더 느림
- MYSQL의 경우 클러스터형 인덱스 지정 순서
    - 기본키
    - `unique` 하면서 `Not Null`
    - 임의로 보이지 않은 컬럼 생성하여 지정

### 보조 인덱스

- 후보키에만 부여가능한 index
- 데이터 페이지는 그냥 두고 별도의 페이지에 인덱스를 구성
- 데이터가 위치하는 주소 값
- 클러스터형에 비해 속도는 느리지만 성능 부하는 적다
- 테이블당 여러개 생성 가능

### Index 전략

- 인덱스는 열 단위로 생성
- `where` 절에서 사용되는 열에 생성
- `where` 절에 사용되는 열이라도 자주 사용해야 가치
- 데이터 중복도가 낮은 열에 생성 해야함
- JOIN에 자주 사용되는 열에 생성하는게 좋음
- 데이터 변경 작업 횟수 고려

## Index 생성

- 특정 테이블에 기본키가 있다면?
    
    ```jsx
    create table test_tbl1
    (
    	a int primary key,
        b int,
        c int
    );
    ```
    
    기본키 기준으로 클러스터 인덱스가 생성 된다.
    
- 특정 테이블에 `unique`, `not null`이 있다면?
    
    ```jsx
    create table test_tbl3
    (
    	a int unique,
        b int unique,
        c int unique not null
    );
    ```
    
    c열에 자동으로 클러스터형 인덱스 생성 
    
- `unique` vs `not null`
    
    ```jsx
    create table test_tbl6
    (
    	a int not null,
        b int unique,
        c int unique
    );
    ```
    
    `unique`에 우선적으로 index가 생성된다.
    

- `unique` 와 `not null` vs 기본 키
    
    ```jsx
    create table test_tbl5
    (
    	a int unique not null,
        b int unique,
        c int unique,
        d int primary key
    );
    ```
    
    기본키가 우선이다.
    

**기본 키 > unique > not null 순서로 클러스터형 인덱스가 생성된다.**

## Index 생성

```jsx
create [unique] index 인덱스 이름
on 테이블 이름 (열이름) [asc | desc]
```

- `create index` 문으로 인덱스 생성시 보조 인덱스 생성
- `unique`  옵션은 고유한 인덱스를 만들 때 사용
- 정렬 방식 지정 가능
- 기본 타입은 B-Tree
- 클러스터형 인덱스의 경우 `alter table` 문을 활용해야한다.


