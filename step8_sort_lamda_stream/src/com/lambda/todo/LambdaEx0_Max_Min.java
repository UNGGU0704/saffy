package com.lambda.todo;

//--- 기존 인터페이스와 메서드 호출 사용 방식
interface IMath {
	int max(int a, int b);
	int min(int a, int b);
}

class MathImpl implements IMath {

	@Override
	public int max(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int min(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class LambdaEx0_Max_Min {
	// 기존 인터페이스와 메서드 호출 사용 방식
	public static void main(String[] args) {
		MathImpl m = new MathImpl();
		int answer = m.max(5, 10);
		System.out.println(answer);
		
		answer = m.min(5, 10);
		System.out.println(answer);
	}
	
	// TODO : Lambda 함수형 인터페이스 구현 및 사용해보자: min(), max()
	public static void main2(String[] args) {
		// (2) 인터페이스형 변수에 람다식(재정의) 대입: max()

		// (3) 인터페이스형 변수를 이용해서 메서드 호출 사용: max()
		
		// (4) 인터페이스형 변수에 람다식(재정의) 대입: min()

		// (5) 인터페이스형 변수를 이용해서 메서드 호출 사용: min()
		
		// [고민] 함수형 인터페이스에 1개의 추상메서드만 가능할까??
		// see: java.lang : Annotation Type FunctionalInterface
	}
}


// TODO : Lambda 함수형 인터페이스 선언 
// (1) Lambda 함수형 인터페이스 선언

