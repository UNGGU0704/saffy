package com.lambda.todo;

// 함수형 인터페이스: 추상메서드가 1개이면 어노테이션 생략 가능
//@FunctionalInterface
interface Item {
	public String getItem();
}

//1. 일반 메서드 -------------------------
public class LambdaEx3 implements Item {
	@Override
	public String getItem() {
		return "1. 컴퓨터";
	}
	
	public static void main(String[] args) {
		LambdaEx3 ob = new LambdaEx3();
		System.out.println(ob.getItem());
	}
}

//2. 익명함수------------------------------------------
//public class LambdaEx3 {
//	public static void main(String[] args) {
//		Item m = new Item() {
//			@Override
//			public String getItem() {
//				return "2. 컴퓨터";
//			}
//		};
//		System.out.println(m.getItem());
//	}
//}


//3. 람다식-------------------------------------------
//public class LambdaEx3 {
//	public static void main(String[] args) {
//		Item ob = () -> "3. 컴퓨터";           
//		//Item ob = () -> { return "3. 컴퓨터"; };
//		System.out.println(ob.getItem());
//	}
//}
