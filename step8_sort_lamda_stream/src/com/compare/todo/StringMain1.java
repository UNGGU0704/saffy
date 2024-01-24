package com.compare.todo;

import java.util.Arrays;
import java.util.Iterator;

// see: java.util.Arrays#sort()
// see: java.lang.String#compareTo
// see: java.lang.Comparable
public class StringMain1 {
	public static void main(String[] args) {
		//--- Arrays.sort() 배열 정렬
		main1();
		
		//--- String#compareTo() 이용한 정렬 구현
		//main2();
	}
	
	// Arrays.sort() 배열 정렬
	private static void main1() {
		StringMain1 test = new StringMain1();
		
		String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		
		test.print("정렬 전 조회");
		test.print(names);
		
		Arrays.sort(names);
		test.print("정렬 후 조회 [원본 변경]");
		test.print(names);
	}

	// String#compareTo() 이용한 정렬 구현(bubble sort)
	public static void main2() {
		StringMain1 test = new StringMain1();
		
		test.print("문자열 크기 비교");
		System.out.println("작은면:\t" + "강감찬".compareTo("이순신"));
		System.out.println("같으면:\t" + "홍길동".compareTo("홍길동"));
		System.out.println("크면:\t" + "홍길동".compareTo("이순신"));
		
		String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		
		// 사용자 정의 sort()
		test.print("정렬 전 조회");
		test.print(names);

		test.sort(names);
		test.print("올림차순 정렬 후 조회[원본 변경]");
		test.print(names);	// 원본 배열객체 정렬변경 저장
		test.print("=", 40);
		
		// 사용자 정의 sort():String[]
		String[] names2 = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		test.print("정렬 전 조회");
		test.print(names2);

		String[] sortNames = test.sort2(names2);
		test.print("정렬 후 조회");
		test.print(sortNames);
		
		test.print("정렬 후 원본 조회[원본 유지]");
		test.print(names2);
	}

	// 사용자 정의 정렬: 올림차순 (bubble sort): 원본을 정렬한 값으로 변경
	public void sort(String[] arr) {
		String tmp = null;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i].compareTo(arr[j]) > 0) { // 양수이면 큰것이니 위치 변경해야지!!
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	// 사용자 정의 정렬: 올림차순 (bubble sort): 원본을 복사해서 정렬 후 복사한 배열 반환(정렬 전 원본 유지)
	public String[] sort2(String[] arr) {
		String[] tmpArr = Arrays.copyOfRange(arr, 0, arr.length);
		String[] tmpArr2 = Arrays.copyOf(arr, arr.length);
		
		String tmp = null;
		for (int i = 0; i < tmpArr.length; i++) {
			for (int j = i+1; j < tmpArr.length; j++) {
				if(tmpArr[i].compareTo(tmpArr[j]) > 0) {
					tmp = tmpArr[i];
					tmpArr[i] = tmpArr[j];
					tmpArr[j] = tmp;
				}
			}
		}
		return tmpArr;
	}
	
	// 테스트를 위한 문자열 출력 메서드
	public void print(String message) {
		System.out.println("******* " + message);
	}
	
	// 테스트를 위한 배열 출력 메서드
	public void print(String[] arr) {
		for (String str : arr) {
			System.out.printf("%s ", str);
		}
		System.out.println();
	}
	
	// 테스트를 위한 출력 메서드
	private void print(String str, int size) {
		StringBuilder head = new StringBuilder();
		for (int i = 0; i < size; i++) {
			head.append(str);
		}
		System.out.println(head);
		System.out.println();
	}
}
