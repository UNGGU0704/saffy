# DDL

> 데이터 정의어 `create`, `drop`, `alter`
> 
- 데이터베이스 객체의 구조를 정의
- 테이블 생성, 컬럼 추가, 타입 변경

## Create

### Date Type

- **CHAR(M)**
    - 고정 길이 문자열 저장
    - CHAR(20)에 10만큼 저장해도 db 자체에는 20만큼 저장소 차지
- **VARCHAR(M)**
    - 가변 길이 문자열 저장
    - VARCHAR(10)에 10만큼 저장을 하면 실제로도 10만큼 저장소 차지
- **TEXT(M)**
    - 최대 65535bye 저장 가능
- **INT(M)**
    - -214783548 ~ 214783548 만큼의 범위를 저장 가능
- **DATETIME**
    - YYYY - MM - DD 의 형식으로 저장

### 테이블 생성

```jsx
CREATE TABLE TABLE_NAME (
    column_name1 Type [선택된 타입],
    column_name2 Type,
					...

);
```

- 선택된 타입
    - **NOT NULL** : `NULL`갑 허용 하지 않음
    - **DEFAULT vlaue** : 기본 값
    - **UNSIGNTED** : 음수를 허용하지 않음
    - **KEY** : 기본키나 외래키를 설정함


## SQL 실습

 

```jsx
# 1.     현재 날짜와 올해가 몇 일이 지났는지,100일 후는 몇일인지 출력하시오.(아래는 2020년 기준 예시) 
SELECT NOW() AS 오늘,
       DATEDIFF(NOW(), '24-01-01') AS 올해_지난_일수,
         DATE_ADD(NOW(), interval 100 DAY) AS 100일_후;
         
# 2.     country에서 asia에 있는 나라 중 희망 수명이 있는 경우에 기대 수명이 80 초과면 장수국가, 60 초과면 일반국가, 그렇지 않으면 단명국가라고 표현하시오. 기대 수명으로 정렬한다.(51건)
 select name, continent, LifeExpectancy,
	case
		when LifeExpectancy > 80 then "장수국가"
        when LifeExpectancy > 60 then "일반국가"
        else "단명국가"
	end as 구분
from country
where LifeExpectancy is not null and Continent = 'asia'
order by LifeExpectancy;

# 3.     country에서 (gnp-gnpold)를 gnp 향상이라고 표현하시오. 단 gnpold가 없는 경우 신규라고 출력하고 name으로 정렬한다.(239건)
 select name, gnp, 
	case
		when gnpOld is null then "신규"
		else gnpOld
	end as gnp_향상
from country
order by name asc;

# 4.     2020년 어린이 날이 평일이면 행복, 토요일 또는 일요일이면 불행이라고 출력하시오. 
SELECT weekday('2020-05-05'),
    CASE 
        WHEN DAYOFWEEK('2020-05-05') IN (2, 3, 4, 5, 6) THEN '행복'
        ELSE '불행'
    END AS 어린이날_행복도;

# 5.     country에서 전체 자료의 수와 독립 연도가 있는 자료의 수를 각각 출력하시오.

select count(Code), count(case when IndepYear is not null then IndepYear end) as 독립_연도_보유
from country;

# 6.     country에서 기대 수명의 합계, 평균, 최대, 최소를 출력하시오. 평균은 소수점 2자리로 반올림한다.

select sum(LifeExpectancy) as 합계, Round(avg(LifeExpectancy),2) as 평균, max(LifeExpectancy) as 최대, min(LifeExpectancy) as 최소
from country; 

# 7.     country에서 continent 별 국가의 개수와 인구의 합을 구하시오. 국가 수로 정렬 처리한다.(7건)

select Continent, count(Code) as "국가 수", sum(population) as "인구 합"
from country
group by Continent;

# 8.     country에서 대륙별 국가 표면적의 합을 구하시오. 면적의 합으로 내림차순 정렬하고 상위 3건만 출력한다.

select Continent, sum(gnp) as "표면접 합"
from country
group by Continent
order by sum(surfaceArea) desc;

# 9.     country에서 대륙별로 인구가 50,000,000이상인 나라의 gnp 총 합을 구하시오. 합으로 오름차순 정렬한다.(5건)

select Continent, sum(case when Population > 50000000 then gnp end) as "gnp 합"
from country
group by Continent
limit 5;

# 10.  country에서 대륙별로 인구가 50,000,000이상인 나라의 gnp 총 합을 구하시오. 이때 gnp의 합이 5,000,000 이상인 것만 구하시오.

SELECT Continent, 
       SUM(gnp) AS gnp_합 
FROM country 
WHERE Population >= 50000000 
GROUP BY Continent 
HAVING SUM(gnp) >= 5000000;

# 11.  country에서 연도별로 10개 이상의 나라가 독립한 해는 언제인가?

select IndepYear , count(IndepYear) as 독립_국가_수
from country
group by IndepYear
having count(IndepYear) > 10;

# 12.  country에서 국가별로 gnp와 함께 전세계 평균 gnp, 대륙 평균 gnp를 출력하시오.(239건)

select name, Continent, gnp, (select avg(gnp) from country) as 전세계평균, (select avg(gnp) from country where c.Continent = Continent) as 대륙평균
from country as c;
```

## SQL 과제
