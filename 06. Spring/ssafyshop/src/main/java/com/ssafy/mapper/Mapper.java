package com.ssafy.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.model.Member;
import com.ssafy.model.Product;



public interface Mapper {
	Member loginMember(Map<String, String> map) throws SQLException;
	int signupMember(Map<String, String> map) throws SQLException;
	
	List<Product> listProduct() throws SQLException;
	void registProduct(Map<String, String> map) throws SQLException;
	void deleteProduct(String id) throws SQLException;
	Product selectProduct(String code) throws SQLException;
	void updateProduct(Map<String, String> map) throws SQLException;
	
}
