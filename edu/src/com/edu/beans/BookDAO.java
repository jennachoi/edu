package com.edu.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO { // 전체 리스트조회, 신규입력, 수정, 삭제 - DBMS

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public BookBean getBook(String title) { // 한건 조회. 타이틀을 리턴
		String SQL = "select * from book where title = ?";
		conn = DAO.connect();
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			if (rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return book;
	}

	// 전체 리스트
	public List<BookBean> getBookList() {
		String SQL = "select * from book";
		conn = DAO.connect();
		List<BookBean> bookList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(SQL);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookBean book = new BookBean();
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bookList;
	}

	// 저자별 책 조회 리스트를 반환
	public List<BookBean> getBooksByAuthor(String author) {
		String SQL = "select * from book where author=?";
		conn = DAO.connect();
		List<BookBean> bookList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, author);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookBean book = new BookBean();
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bookList;
	}

	// 한건 입력
	public BookBean insertBook(BookBean book) {
		String SQL = "insert into book values(?,?,?)";
		conn = DAO.connect();
		BookBean books = new BookBean();
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return books;
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
