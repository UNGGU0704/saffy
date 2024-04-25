package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.mapper.Mapper;
import com.ssafy.model.Member;
import com.ssafy.model.Product;

@Service
public class MainServiceImpl implements MainService {

	private final Mapper mapper;
	
	
	public MainServiceImpl(Mapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public Member loginMember(Map<String, String> map) throws SQLException {
		return mapper.loginMember(map);
	}

	@Override
	public List<Product> listProduct() throws SQLException {
		return mapper.listProduct();
	}

	@Override
	public void registProduct(Map<String, String> map) throws SQLException {
		mapper.registProduct(map);
	}

	@Override
	public void deletePorcut(String code) throws SQLException {
		mapper.deleteProduct(code);
	}

	@Override
	public Product select(String code) throws SQLException {
		return mapper.selectProduct(code);
	}

	@Override
	public void updateProduct(Map<String, String> map) throws SQLException {
		mapper.updateProduct(map);
	}

	@Override
	public int signupMember(Map<String, String> map) throws SQLException {
		return mapper.signupMember(map);
	}

}
