package com.ssafy.ws.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.dto.User;

@Mapper
public interface UserDao {
	User select(String id);
	
	User login(User user);
}
