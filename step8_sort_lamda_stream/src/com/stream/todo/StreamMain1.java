package com.stream.todo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain1 {

	public static void main(String[] args) {
		main1();
		main2();
		main3();
	}
	
	/* reduce() 연산
	 * - 정의된 연산이 아닌 개발자가 직접 지정하는 연산을 적용
	 * - 최종 연산으로 스트림의 요소를 소모하며 연산 수행
	 * - 배열의 모든 요소의 합을 구하는 reduce() 연산
	 */
	public static void main3() {
		// 배열의 모든 요소의 합구하기!!: reduce()
		int[] array = {1, 2, 3, 4, 5}; // 1+2+3+4+5 = 15
		
		// 배열에 여러 문자열이 있을때 가장 긴 문자열 찾기
		String[] strArray = {"Java", "DataBase", "Algorithm Test", "Web", "HTML"};
	}
	
	public static void main2() {
		// List에 스트림 이용하여 요소 출력하기
		List<String> strList = Arrays.asList("Java", "DataBase", "Algorithm", "Web", "HTML");
	
		// stream 이용해서 요소 출력하기
		
		// stream 이용해서 요소 정렬 출력하기
	}
	
	public static void main1() {
		// stream 이용해서 문자열의 길이가 5 이상인 요소만 출력하기
		List<String> strList = Arrays.asList("Java", "DataBase", "Algorithm", "Web", "HTML");
		
		// stream 이용해서 회원 이름 정보만 가져와서 출력하기
		List<Member> personList = Arrays.asList(
				new Member("홍길동", 35),
				new Member("강감찬", 25),
				new Member("김유신", 22),
				new Member("이순신", 22),
				new Member("유관순", 15)
		);
		
		//--- 정수배열에 스트림 생성 사용하기
		int[] array = {1, 2, 3, 4, 5};
		
		// 합계 출력
				
		// 배열 요소의 갯수 출력
		
		// 배열요소의 값이 2의 배수만 출력
		
		// 배열요소의 값이 2의 배수만 갯수 카운팅 
	}

}

class Member {
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(", ");
		builder.append(age);
		return builder.toString();
	}
}
