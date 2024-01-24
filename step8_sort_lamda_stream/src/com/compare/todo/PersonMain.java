package com.compare.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// TODO:
// 객체 자체에 기본 정렬기준 구현 : 
// 단일 정렬기준 고정, 정렬 기준 변경시 클래스 변경
class Person {
    private String name;
    private int age;

    // constructor, getters, setters 생략
    public Person(String name, int age) {
    	this.name = name;
    	this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String toString() {
    	return name + ", " + age;
    }
}

// 외부에서 정렬 기준 제공하는 별도의 클래스 또는 람다식 사용
// 다중 정렬 구현, 클래스 변경 없이 다양한 정렬 기준 추가 및 변경 가능
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        // 나이를 기준으로 정렬
        return Integer.compare(person1.getAge(), person2.getAge());
    }
}

class PersonMain {
	public static void main(String[] args) {
		Person[] array = {
				new Person("홍길동", 35),
				new Person("강감찬", 25),
				new Person("김유신", 22),
				new Person("이순신", 22),
				new Person("유관순", 15)
		};
		
		// 배열객체 정보를 List로 변경
		List<Person> list = Arrays.asList(array);
		
		// 정렬 전 원본 출력
		System.out.println("1.--------");
		for (Person p: array) {
			System.out.println(p);
		}

		System.out.println("1.--------");
		for (Person p: list) {
			System.out.println(p);
		}
		
		// 객체 설정된 기본 정렬 - 나이 올림차순: Comparable#compareTo()
		
		// 정렬 동적 변경 - 나이 내림차순
		
		// 정렬 동적 변경 - 나이 올림차순, 나이가 같으면 이름 올림차순 
		
		// 정렬 동적 변경 - 이름 올림차순
		
		// 정렬 동적 변경 - 내림 올림차순
	}
}
