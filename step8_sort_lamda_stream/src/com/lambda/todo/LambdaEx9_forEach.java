package com.lambda.todo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LambdaEx9_forEach {
	public static void main(String[] args) {
		// collection
		List<Integer> list = Arrays.asList(3, 6, 9);
		
		// jdk1.5: enhance for
		for(Integer i: list) {
			System.out.println(i);
		}
		System.out.println("-----------------");
		
		// Iterator
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------");
		
		// 람다식
		list.forEach(n -> System.out.println(n));
		System.out.println("-----------------");
		
		list.forEach((Integer n) -> System.out.println(n));
		System.out.println("-----------------");
		
		// :: 더블콜론 연산자
		list.forEach(System.out::println);
		System.out.println("-----------------");
		
		List<String> list2 = Arrays.asList("hello", "hi", "welcome", "jambo");
		list2.forEach(System.out::println);
		System.out.println("-----------------");
		
		list2.forEach(str -> System.out.println(str.toUpperCase()));
		System.out.println("-----------------");
	}
}
