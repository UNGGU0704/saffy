package com.ssafy.ws.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.model.dao.BookDaoImpl;
import com.ssafy.ws.model.dto.Book;

public class BookTest {
	public static void main(String[] args) {
		
		BookDao bookDao = new BookDaoImpl();
		
		System.out.println("조회 Test search : 111-222-9999");
		Book book = bookDao.select("111-222-9999");
		System.out.println(book.toString());
		System.out.println("업데이트 Test search : 111-222-9999 ");
		bookDao.update(book);
		book = bookDao.select("111-222-9999");
		System.out.println(book.toString());
		
		System.out.println("삭제 Test");
		bookDao.delete("111-222-9999");
		
	}
}
