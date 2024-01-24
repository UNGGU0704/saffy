package com.compare.todo;

import java.util.Arrays;
import java.util.Comparator;

// Student2 정렬 메서드 정의 되어 있지 않음: 
// 동적 정렬: 정렬이 필요할때마다 익명의 클래스로 정의해서 사용
// 동적 정렬: Comparator#compare()
class Student2 {
	String name;
	int num;
	double score;
	
	public Student2() {}
	
	public Student2(String name, int num, double score) {
		this.name = name;
		this.num = num;
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("\t| ");
		builder.append(num);
		builder.append("\t| ");
		builder.append(score);
		return builder.toString();
	}
}

public class StudentMain2 {
	public static void main(String[] args) {
		Student2[] array = new Student2[5];
		array[0] = new Student2("홍길동", 20170301, 4.5);
		array[1] = new Student2("강감찬", 20200301, 3.5);
		array[2] = new Student2("이순신", 20180301, 2.5);
		array[3] = new Student2("김유신", 20210301, 4.5);
		array[4] = new Student2("유관순", 20200302, 3.5);
		
		//--- (Anonymous inner class)
		//--- (1)익명 중첩 클래스 : 학점이 높은순서(내림차순)대로 정렬 조회
		Arrays.sort(array, new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				return Double.compare(o2.score, o1.score); // 학점이 동일한 사람이 존재
				//return (int)(o2.score - o1.score);		
			}
		});
		print("(1) 학점이 높은순서(내림차순)", array);
		
		// (2) 익명 중첩 클래스
		// 학점이 높은순서(내림차순)대로 정렬 조회. 만약,학점이 같으면 학번으로 오름차순정렬하시오
		// TODO:
		
		print("(2)학점이 내림차순, 동점이면 학번 오름차순", array);
		
		//------------------------------------------------------
		// (3) 익명 중첩 클래스
		// 이름으로 오름차순
		// TODO:

		print("(3)이름 오름차순", array);
		
		//------------------------------------------------------
		// (4) 람다식: 이름으로 오름차순
		// TODO:
		
		print("(4)람다식: 이름으로 오름차순", array);
		
		// (5) 람다식: 점수가 낮은순서(올림차순)
		// TODO:

		print("(5)람다식: 점수 낮은순서(올림차순)", array);
		
		// (6) 람다식: 점수가 높은순서대로(내림차순), 단, 점수가 같으면 이름 올림차순
		// TODO:

		print("(6)람다식: 점수 높은순서, 동점이면 이름 올림)", array);
		
		//------------------------------------
//		System.out.println("정렬 후 조회");
//		for(int i=0; i<array.length; i++) {
//			System.out.println(array[i]);   
//		}
	}
	
	// 정렬 후 조회 출력 테스트를 위한 메서드
	public static void print(String title, Student2[] array) {
		System.out.println("\n--- " + title + " 정렬 후 조회");
		for (Student2 s: array) {
			System.out.println(s);
		}
	}
}


/* 수행결과

--- (1) 학점이 높은순서(내림차순) 정렬 후 조회
홍길동	| 20170301	| 4.5
김유신	| 20210301	| 4.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5

--- (2)학점이 내림차순, 동점이면 학번 오름차순 정렬 후 조회
홍길동	| 20170301	| 4.5
김유신	| 20210301	| 4.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5

--- (3)이름 오름차순 정렬 후 조회
강감찬	| 20200301	| 3.5
김유신	| 20210301	| 4.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5
홍길동	| 20170301	| 4.5

--- (4)람다식: 이름으로 오름차순 정렬 후 조회
강감찬	| 20200301	| 3.5
김유신	| 20210301	| 4.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5
홍길동	| 20170301	| 4.5

--- (5)람다식: 점수 낮은순서(올림차순) 정렬 후 조회
이순신	| 20180301	| 2.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
김유신	| 20210301	| 4.5
홍길동	| 20170301	| 4.5

--- (6)람다식: 점수 높은순서, 동점이면 이름 올림) 정렬 후 조회
김유신	| 20210301	| 4.5
홍길동	| 20170301	| 4.5
강감찬	| 20200301	| 3.5
유관순	| 20200302	| 3.5
이순신	| 20180301	| 2.5
*/










