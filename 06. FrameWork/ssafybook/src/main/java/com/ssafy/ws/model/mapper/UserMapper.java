package com.ssafy.ws.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.ws.model.dto.User;

@Mapper
public interface UserMapper {
    User select(String id);
    
    User login(User user);
}	
