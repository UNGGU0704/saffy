# JOIN & SubQuery

## JOIN

> 둘이상의 테이블에서 데이터가 필요한 경우 사용하는 형식
> 

### INNER JOIN

- 가장 일반적인 JOIN의 종류
- 교집합
- N개의 테이블 조인 시 N - 1개의 조인 조건이 필요

```jsx
SELECT COL1, COL2,,, COLn

-- using을 활용하는 방식
FROM TABLE1 JOIN TABLE2 USING(공통COLUMN);

-- on을 사용하는 방식 
FROM TABLE1 INNER JOIN TABLE2 ON TABLE1.C = TABLE2.C

-- where 절을 이용하는 방식
FROM TABLE1 T1, TABLE2
WHERE T1.id = T2.id
```

- `using` 절에서는 alias를 명시하면 오류난다.

### Outer Join

- Left outer join, full outer join 등으로 구분 됨
- 한쪽 테이블에는 존재하지만 다른 테이블에는 존재하지 않을 때 주로 사용
- MySQL에서 outer join은 지원하지 않는다.
- 아래와 처럼 left와 right를 동시에 해서 합집합 하면 비슷한 효과를 얻을 수 있다.

```jsx
SELECT * FROM TableA A LEFT JOIN TableB B 
UNION
SELECT * FROM TableA A RIGHT JOIN TableB B
```

### Self Join

- 같은 테이블끼리 Join

```jsx
select e.id, e.name, m.id, m.name
from employees e inner join employees m
on e.id = m.id;
```

- 모든 사원의 정보를 알고 싶을 때 사용한다.

### None-Equi Join

- PK나 FK가 아닌 일반 컬럼으로 join
- 모든 사원의 정보를 받을 수 있다.

## SubQuery

- 다른 쿼리 내부 안에 있는 SELECT문
- 서브 쿼리를 포함하고 있는 쿼리를 외부 쿼리, 서브쿼리를 내부 쿼리라고 한다.

### 서브 쿼리의 종류

- 중첩 서브 쿼리 : WHERE 문에 작성하는 서브 쿼리
    - 단일 행
    - 복수 행
    - 다중 컬럼
- 인라인 뷰 : FROM문에 작성하는 서브 쿼리
- 스칼라 서브 쿼리 : SELECT문에 작성하는 서브 쿼리

- insert나 update의 경우 동일 테이블에서 서브쿼리가 사용불가