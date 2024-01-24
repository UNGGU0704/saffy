package com.lambda.todo;

//자바함수형 interface, 람다식으로 사용할 것을 선언
//함수는 반드시 1개
@FunctionalInterface
interface Print { 
	public void view();  
}

//3. 일반 메서드 형태-----------------------------------------
public class LambdaEx1 implements Print {
	@Override
	public void view() {
		System.out.println("3. Hello Lambda");
	}
	
	public static void main(String[] args) {
		new LambdaEx1().view();
	}
}

//2. 익명 중첩클래스 형태(Anonymous inner class)----------------
//public class LambdaEx1{
//	public static void main(String[] args) {
//	}
//}


//1. 람다식 형태 : 인터페이스형 변수에 람다식 대입 ----------------------
//public class LambdaEx1{
//	public static void main(String[] args) {
//	}
//}





