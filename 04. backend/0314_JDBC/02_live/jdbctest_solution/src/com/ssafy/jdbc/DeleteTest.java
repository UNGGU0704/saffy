package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	private final String DB_ID = "ssafy";
	private final String DB_PWD = "ssafy";

	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		int cnt = dt.delete("kimssafy2");
		System.out.println(cnt + "개 삭제 성공 !!!");
	}

	private int delete(String userId) {
		int cnt = 0;
		String sql = "";
		sql += "delete from ssafy_member \n";
		sql += "where userid = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, userId);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
