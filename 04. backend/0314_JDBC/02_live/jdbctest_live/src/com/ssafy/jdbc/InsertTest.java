package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	private final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	private final String DB_ID = "ssafy";
	private final String DB_PWD = "ssafy";
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		int cnt = it.register("troment", "안효인", "9988", "troment", "google.com");
		System.out.println(cnt + "개 입력 성공!!!");
	}

	private int register(String userId, String userName, String userPwd, String emailId, String emailDomain) {
		int cnt = 0;
		
		String sql = "";
		sql += "insert into ssafy_member (userid, username, userpwd, emailid, emaildomain) \n";
		sql += "values (?, ?, ?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
				PreparedStatement pstmt = conn.prepareStatement(sql);)  {
//			conn.setAutoCommit(false);
			int i = 0;
			pstmt.setString(++i, userId);
			pstmt.setString(++i, userName);
			pstmt.setString(++i, userPwd);
			pstmt.setString(++i, emailId);
			pstmt.setString(++i, emailDomain);
			cnt = pstmt.executeUpdate();
//			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
//			conn.rollback();
//			conn.rollback(null);
		} 
		return cnt;
	}
}
