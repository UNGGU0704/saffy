package com.lambda.todo;

/* 2. 람다식 --------------------------
 * [문제]간단한 계산기를 람다식으로 작성하시오
 * 
 * 1. 인터페이스명 : Calculator
 *  + calculate(a:int, b:int) : double
 *    
 * 2. LambdaEx5에서 
 *    Calculator 객체변수를 만들고 2,5값을 가지고 더하기/빼기/곱하기/나누기를 완성하시오
 *    
 * [실행결과]
 * 7
 * -3
 * 10
 * 0.4   
 */
//@FunctionalInterface
//interface Calculator {
//	public double calculate(int a, int b);
//}
//
//public class LambdaEx5 {
//	public static void main(String[] args) {
//
//	}
//}

//1. 일반메서드 --------------------------
interface Calculator {
	public double add(int a, int b);
	public double sub(int a, int b);
	public double multiply(int a, int b);
	public double divide(int a, int b);	
}

public class LambdaEx5 implements Calculator {
	@Override
	public double add(int a, int b) { return a+b; }

	@Override
	public double sub(int a, int b) { return a-b; }

	@Override
	public double multiply(int a, int b) { return a*b; }

	@Override
	public double divide(int a, int b) { return (double)a/b; }
	
	public static void main(String[] args) {
		LambdaEx5 ob=new LambdaEx5();
		System.out.println((int)ob.add(2,5));
		System.out.println((int)ob.sub(2,5));
		System.out.println((int)ob.multiply(2,5));
		System.out.println(ob.divide(2,5));
	}
}
