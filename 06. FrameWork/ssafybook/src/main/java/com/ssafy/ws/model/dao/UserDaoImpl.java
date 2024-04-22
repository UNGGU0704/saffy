package com.ssafy.ws.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.ws.util.SqlMapConfig;
import com.ssafy.ws.model.dto.User;

public class UserDaoImpl implements UserDao {

	private final String NAMESPACE = "com.ssafy.ws.model.dao.User.";
	@Override
	public User select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(User user) {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE + "login", user);
		}		
	}

}
