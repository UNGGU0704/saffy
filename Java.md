# Java 기본(24. 01 .15)

## 자바의 자료형

### 기본형

- **정수** → byte, short, int, long
- **실수 →** float, double
- 정수 계산시 overflow 주의
- 실수 계산
    
    ```jsx
    double d1 = 2.0;
    double d2 = 1.1;
    double d3 = d1 - d2;
    
    System.out.println(d3);
    
    d3 : 0.899999999...
    ```
    
    - 왜 0.9가 아닐까? → *실수의 연산은 정확하지 않다.*

### 참조형

- 8개의 기본형 타입이 아닌 모든 타입들

### 자바 데이터 타입의 기본값

- 정수형 : 0
- 실수형 : 0.0
- 논리형 : false
- 단일문자 : ‘\u0000’ (공백문자)
- 참조형 : null

### 형 변환

명**시적 형변환** : 값 손실의 가능성

**묵시적 형변환** : 자료손실의 걱정이 없음

- 변수의 type 을 다른 type으로 casting 하는 것
- 기본형은 기본형끼리, 참조형은 참조형끼리 형변환이 가능하다.
- 기본형 ↔ 참조형 형변환에는 `Wrapper` 클래스를 사용해야한다.
- 산술연산에 있어 연산전에 피 연산자의 타입을 일치시키는 작업을 한다.
    - 피 연산자의 크기가 4byte 미만이면 int로 변경 후 연산 진행
    - 두 피연산자 중에 큰 타입으로 형 변환 후에 연산 진행

### Short circuit

- **&, && 와 |, ||의 차이는?**
    - **&, |** : 연산자의 앞 조건식과 뒤 조건식을 둘다 실행한다.
    - **&&, ||** : 연산자의 앞 조건식의 결과에 따라 조건식의 실행 여부를 결정한다.
    - **&&, ||** 같은 연산자를 **short circuit** 이라고 한다. → 연산의 최소화

## 반복문

- **반복문의 4가지 요소** : 변수 초기화, 반복 조건, 증감식, 실행문

### 배열

- 동일한 타입의 데이터 0개 이상을 하나의 연속된 메모리 공간에서 관리하는 것
- 배열은 **Immutable** 이다.
    - 배열은 최초 메모리 할당 이후 변경할수 없다.
    - `nums[1] = 100;` 를 사용한다면 개별 요소의 다른 값으로 변경만 한것
    - `new` 등을 사용해서 사이즈를 재조절 한다고 해도 새로운 배열이 만들어지는 것이다.
    - 잘못된 인덱스의 접근시에 *ArrayIndexOutOfBoundExceptions*  예외를 발생

## 생성자

- 객체 생성 전에 처리해야할 함수
- 멤버 변수 초기화를 진행

### 추상 클래스

- 자식클래스에서 반드시 재정의 되기 때문에 조상의 구현이 무의미한 메서드
- 구현의 강제성을 통해 프로그램의 안정성 향상

### 인터페이스

- 최고 수준의 추상화 단계
- 다중 상속이 가능
- 손쉬운 모듈 교체 지원
- *default* 메서드는 인터페이스에 구현된 일반 메서드이다.
    - 접근 제한자는 public으로 한정됨
    - 자식 클래스에서 구현할 필요는 없다.
- *static* 메서드는 미리 만들어놔서 사용이 가능하다.
- 인터페이스를 사용한다면 독립적인 협업에 있어서 개발기간 단축 가능
    - 하나의 인터페이스를 두고 양 팀이 인터페이스를 기반으로 로직 / UI 개발 가능
    - Interface + stub + Impl…

## Collections

### List

- 순서가 있는 데이터의 집합
- 중복을 허용
- ArrayList, LinkedList 등의 구현체가 있다.

### Set

- 순서가 없고 중복을 허용하지 않는 데이터 집합
- HashSet, TreeSet, LinkedHashSet 등의 구현체가 있다.

### Map

- Key-Value 쌍으로 데이터를 저장하는 데이터 집합
- key는 unique해야한다. → **Set** 으로 저장
- HashMap, TreeMap, LinkedHashMap 등의 구현체가 있다.

### Queue

- FIFO(First-In, First-Out) 원칙에 따라 요소를 처리하는 데이터 집합
- LinkedList, PriorityQueue 등의 구현체가 있다.

## Generic

- 객체 생성시에 타입을 결정하는 타입
    - <T> : Type Object
    - <E> : Element Object
    - <K> : Key Object
    - <V> : Value Object
### 과제

**데일리 실습** : 2008. 빌딩 건설 (LV3)

```jsx
import java.io.*;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이 
 * 24.01.15
 * @author 김규형
 */
public class Solution {
	
	static int[] DX = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] DY = {0, 1, 0, -1, -1, 1, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 수행횟수
		
		int[] answers = new int[N]; // 답 저장 배열 
		int answerCount = 0; // 답 배열 인덱스
		
		for (int tc = 0; tc < N; tc++) {
			int M = Integer.parseInt(br.readLine()); //구획의 크기 
			int MAX = Integer.MIN_VALUE; //최댓값 (정답)
			char[][] map = new char [M][M]; 
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = st.nextToken().charAt(0); //입력받은 정보로 객체를 생성
				}
			}
			// 입력 종료 
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					boolean isGarden = false; // 인접 칸 중에 정원이 있는지를 기억하는 변수
					int buildingCount = 0; // 주변 빌딩의 갯수를 받는 변수
					for (int w = 0; w < 8; w++) {
						int dy = i + DY[w];		int dx = j + DX[w]; //인접칸들을 설정한다.
						
						if (dy >= M || dx >= M || dy <= -1 || dx <= -1) continue; // 인접칸 체크 
						
						if (map[dy][dx] == 'G') { //인접칸에 공원이 있다면 2로 고정 
							isGarden = true;
							break; // 더이상 계산할 필요가 없음 
						}
					}
					if (isGarden) // 정원이 있다면 높이는 2로 고정 
						buildingCount = 2;
					else //정원이 없다면 높이를 계산한다.
						buildingCount = countBuildingHigh(map, M, i, j);
					
					MAX = Math.max(MAX, buildingCount);
				}
			}
			// 로직 종료
			answers[answerCount++] = MAX; // 답 설정
		
		}
		
		//출력
		for (int answer : answers) {
			System.out.println("# " + answer);
		}
	}
	
	/**
	 * 빌딩의 높이를 계산하는 메서드 
	 * @param map
	 * @param M
	 * @param y
	 * @param x
	 * @return
	 */
	public static int countBuildingHigh(char[][] map, int M, int y, int x) {
		int buildingCount = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if ((i == y || j == x) && map[i][j] == 'B') {// 상하좌우의 빌딩의 갯수를 모두 계산한다.
					buildingCount++;
				}
			}
		}
		return buildingCount;
	}
}
```

**데일리 과제** : 2032. 사과나무 영양분 구하기 (LV2)

```jsx
import java.io.*;
import java.util.StringTokenizer;

/**
 * 알고리즘 풀이 
 * 24.01.15
 * @author 김규형
 */
public class Solution {
	
	static int[] DX = {-1, 0, 1, 0};
	static int[] DY = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine()); // 수행횟수
		int MAX = Integer.MIN_VALUE; // 최댓값 (정답)
		int[][] map = new int [M][M]; //농지의 땅
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); //입력받은 정보로 객체를 생성
			}
		}
		// 입력 종료 
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int feedCount = map[i][j]; // 해당 땅의 영양분
				for (int w = 0; w < 4; w++) {
					int dy = i + DY[w];		int dx = j + DX[w]; //인접칸들을 설정한다.
					
					if (dy >= M || dx >= M || dy <= -1 || dx <= -1) continue; // 인접칸 체크 
					feedCount += map[dy][dx]; // 인접 땅의 영양분을 계산
				}
				MAX = Math.max(MAX, feedCount); // 최댓값 비교 
			}
		}

		System.out.println(MAX); //영양분의 가장 최댓값을 설정한다.
	}
}
```

```jsx
5
1 1 1 1 1
1 1 1 2 2
1 1 1 2 1
1 9 1 1 1
1 1 1 1 1

13
```
