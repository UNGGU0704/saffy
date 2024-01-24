package com.lambda.todo;

//1. 람다식-------------------------------------------
//public class LambdaEx2 {
//	public static void main(String[] args) {
//	}
//}

//2. 익명함수------------------------------------------
// new Thread().start(); => new Thread(new Run입력 => ctrl+space Runnable() 선택 => 자동완성 ).start();
//public class LambdaEx2 {
//	public static void main(String[] args) {
//	}
//}


//3. 일반 메서드 : Thread ----------------------------------
class MyThread implements Runnable {
	@Override
	public void run() {
		System.out.println("1. Hello Thread");
	}
}

public class LambdaEx2 {
	public static void main(String[] args) {
		//MyThread ob = new MyThread();
		//Thread th = new Thread(ob);
		//th.start();
		
		new Thread(new MyThread()).start();
	}
}
