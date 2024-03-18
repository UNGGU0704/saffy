package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	private final String DB_ID = "ssafy";
	private final String DB_PWD = "ssafy";

	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		int cnt = ut.modify("kimssafy2", "9999");
		System.out.println(cnt + "개 변경 성공 !!!");
	}

	private int modify(String userId, String userPwd) {
		int cnt = 0;
		String sql = "";
		sql += "update ssafy_member \n";
		sql += "set userpwd = ? \n";
		sql += "where userid = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
