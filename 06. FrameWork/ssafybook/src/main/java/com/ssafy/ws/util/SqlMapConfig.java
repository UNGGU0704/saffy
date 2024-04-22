package com.ssafy.ws.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SQL Session 생성
 */
public class SqlMapConfig {

	private static SqlSessionFactory factory;

	static {
		try {
			String resource = "mappers/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
            Properties properties = new Properties();
            properties.load(Resources.getResourceAsReader("mappers/dbinfo.properties"));
			factory = new SqlSessionFactoryBuilder().build(reader, properties);
			System.out.println("[Log] : SQL Session이 생성 됨! ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession() {
		return factory.openSession();
	}

}
