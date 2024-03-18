package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectTest {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	private final String DB_ID = "ssafy";
	private final String DB_PWD = "ssafy";

	private String login(String id, String pwd) {
		String name = null;
		String sql = "";
		sql += "select username \n";
		sql += "from ssafy_member \n";
		sql += "where userid = ? and userpwd = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					name = rs.getString("username");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	private String login2(MemberDto memberDto) {
		System.out.println("login 2");
		String name = null;
		String sql = "";
		sql += "select username \n";
		sql += "from ssafy_member \n";
		sql += "where userid = ? and userpwd = ?";
		try (Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
				PreparedStatement pstmt = this.makePreparedStatement(conn, sql, memberDto);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				name = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	private PreparedStatement makePreparedStatement(Connection conn, String sql, MemberDto memberDto)
			throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDto.getUserId());
		pstmt.setString(2, memberDto.getUserPwd());
		return pstmt;
	}

	private List<MemberDto> list() throws SQLException {
		List<MemberDto> list = new ArrayList<MemberDto>();
		String sql = "";
		Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
		sql += "select * \n";
		sql += "from ssafy_member";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs;) {
			while (rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setIdx(rs.getInt("idx"));
				memberDto.setUserId(rs.getString("userid"));
				memberDto.setUserName(rs.getString("username"));
				memberDto.setUserPwd(rs.getString("userpwd"));
				memberDto.setEmailId(rs.getString("emailid"));
				memberDto.setEmailDomain(rs.getString("emaildomain"));
				memberDto.setJoinDate(rs.getString("joindate"));

				list.add(memberDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		String id = "kimssafy";
		String pwd = "1234";
//		String name = st.login(id, pwd);

		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(id);
		memberDto.setUserPwd(pwd);
		String name = st.login2(memberDto);
		if (name != null)
			System.out.println(name + "님 안녕하세요.");
		else
			System.out.println("아이디 또는 비번 확인 후 다시 로그인해 주세요.");

		System.out.println("------------------------------");
		System.out.println("[[ 회원목록 ]]");
		try {
			List<MemberDto> list = st.list();
			for (MemberDto user : list)
				System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
