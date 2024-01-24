package com.lambda.todo;

// see: https://docs.oracle.com/javase/8/docs/api/index.html 
// 함수형 인터페이스에는 추상메서드는 1개만 가능
// default, static 메서드는 가능할까요?? Object#equals(Object) 가능할까요??
@FunctionalInterface
interface Function {
	public int calculate(int a, int b);
	
	//---- TODO
}

public class LambdaEx6 {
	public static void main(String[] args) {
		Function m1=(a,b)-> a+b;
		Function m2=(a,b)-> a-b;
		
		int m3=m1.calculate(10, 20) + m2.calculate(30, 40);
		System.out.println("결과:" + m3);  // 20
		
		//---- TODO
	}
}
