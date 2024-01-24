package com.lambda.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaEx7 {
	public static void main(String[] args) {
//		List<String> list1 = new ArrayList<>();
//		list.add("월");
//		list.add("화");
//		list.add("수");
//		list.add("목");
//		list.add("금");
		
		List<String> list = Arrays.asList("월", "화", "수", "목", "금");
		
		// jdk1.5 : Enhance for
		for(String m : list){
			System.out.println(m + "요일");
		}
		System.out.println("------");
		
		// 람다식 : forEach(람다식)
		list.forEach((m)-> System.out.println(m + "요일"));
		// see: java.lang.Iterable > java.util.Collection > java.util.List
		// void java.lang.Iterable.forEach(Consumer<? super String> action)
		
		System.out.println("------");
		
		// :: 더블콜론 연산자
		// 더블콜론 연산자를 사용하여 해당 클래스 이름을 통해서 메서드를 참조하여 호출 가능
		list.forEach(System.out::println);
	}
}
