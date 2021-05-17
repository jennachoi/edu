package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public MemberDAO() {
//		DataSource ds = DataSource.getInstance();
//		conn = ds.getConnection();
		// Connection Pool을 활용해서 Connection 객체 가져오기!
		try {
			InitialContext ic = new InitialContext();  // 서버의 resource들을 관리해주는 객체
			javax.sql.DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void insertMember(Member mem) {
		String sql = "insert into member(member_id, member_name, member_age, member_pwd) values (?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemberId());
			psmt.setString(2, mem.getMemberName());
			psmt.setInt(3, mem.getMemberAge());
			psmt.setString(4, mem.getMemberPwd());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public Member checkInfo(String id, String pwd) {
		String sql = "select * from member where member_id=? and member_pwd=?";
		Member mem = new Member();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			while (rs.next()) {
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberPwd(rs.getString("member_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}	
		return mem; 
	}
	
	// 클릭하면 한건 조회
	public Member getMember(String id) {
		String sql = "select * from member where member_id=?";
		Member mem = new Member();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberPwd(rs.getString("member_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}	
		return mem; 
	}

	public List<Member> getMemberList() {
		String sql = "select * from member order by 1";
		List<Member> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberPwd(rs.getString("member_pwd"));

				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
