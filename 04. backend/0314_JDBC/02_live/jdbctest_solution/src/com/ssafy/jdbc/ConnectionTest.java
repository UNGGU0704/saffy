package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
    private final String DB_ID = "ssafy";
    private final String DB_PWD = "ssafy";
	
//	public ConnectionTest(){
//		try {
//			Class.forName(DRIVER);
//			System.out.println("Driver Loading Success !!!");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	private void connectionTest() {
		try {
			Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
			System.out.println("DB Connection Success !!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.connectionTest();
	}
	
}
