package com.compare.todo;

import java.util.Arrays;

// Student1 객체 속성기반 고정 정렬 클래스 구현: 
// 고정 정렬: implements Comparable<Student1> 
class Student1 implements Comparable<Student1> {
	String name;
	int num;
	double score;
	
	public Student1() {}
	
	public Student1(String name, int num, double score) {
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
	
	// see: String
	// see: Wrapper(Integer, Double): 
	// 	=> static int	compare(double d1, double d2)
	// 	=> int	compareTo(Double anotherDouble)
	@Override
	public int compareTo(Student1 o) {
		// String 은 compareTo()
		// this가 앞에오면 오름차순(이름)
		return this.name.compareTo(o.name);     
	
	}
}

public class StudentMain1 {
	public static void main(String[] args) {
		Student1[] s=new Student1[5];
		s[0]=new Student1("홍길동", 20170301, 4.5);
		s[1]=new Student1("강감찬", 20200301, 3.5);
		s[2]=new Student1("이순신", 20180301, 2.5);
		s[3]=new Student1("김유신", 20230301, 4.5);
		s[4]=new Student1("유관순", 20200302, 3.5);
		
		
		// Student에서 재정의한 compareTo() 기반 정렬
		// 이름 올림 정렬[기본 정렬설정], 
		Arrays.sort(s);
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);   
		}

		// TODO: 이름 내림 정렬, 성적 올림, 성적 내림, 학번 올림, 학번 내림
		// implements Comparable#compareTo() 는 고정 정렬이므로 
		// 매번 해당 객체에 대한 소스코드를 변경해야함(불편!!!)
	}
}














