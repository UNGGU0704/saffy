package com.ssafy.ws.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.util.SqlMapConfig;

public class BookDaoImpl implements BookDao {
	
	private final String NAMESPACE = "aaaa.";

	@Override
	public int insert(Book book) {
		int result = 0;
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			
			result =  sqlSession.insert(NAMESPACE + "insert", book);
			sqlSession.commit();
		}	return result;
	}

	@Override
	public int update(Book book) {
		int result = 0;
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			book.setPrice(book.getPrice() + 100);
			System.out.println(book.toString());
			result = sqlSession.update(NAMESPACE + "update", book);
			sqlSession.commit();
		}
		return result;
	}

	@Override
	public int delete(String isbn) {
		int result = 0;
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			result = sqlSession.delete(NAMESPACE + "delete", isbn);
			sqlSession.commit();
		}
		return result;
	}

	@Override
	public Book select(String isbn) {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "select", isbn);
		}
	}

	@Override
	public List<Book> selectAll() {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList(NAMESPACE + "list");
		}
	}

}
