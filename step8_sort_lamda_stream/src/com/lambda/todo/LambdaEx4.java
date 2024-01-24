package com.lambda.todo;

@FunctionalInterface
interface Ver {
	public String call(String v);  
}

public class LambdaEx4 {
	public static void main(String[] args) {
		//--- 메서드의 형식은(인자1개, 반환타입 String) 한개인데 필요할때 재정의해서 다양하게 활용 가능
		Ver v = (s) -> (s.equals("Java") ? "ver 8.0" : "ver 5.0");
		System.out.println("Java: " + v.call("Java"));
		System.out.println("Spring: " + v.call("Spring"));
		
		//--------------------------------------------------------
		// TODO: (인자1개, 반환타입 String) 메서드 형식 활용
	}
}
