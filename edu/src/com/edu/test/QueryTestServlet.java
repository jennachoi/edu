package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby"); // 받아오는 값이 여러개일때 배열로 받아온다.  
		String gender = req.getParameter("gender");
		String rel = req.getParameter("religion");
		String intro = req.getParameter("introduction");
		resp.setContentType("text/html;charset=UTF-8");		
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>Query 문자열</title></head>"
				+ "<body><h1>Get방식 요청</h1>"
				+ "<h3>ID: "+id+"</h3>"
				+ "<h3>비밀번호: "+pwd+"</h3>"
				+ "<h3>이름: "+name+"</h3>");
				for(String hob : hobby) {
					out.print("<h3>취미: "+hob+"</h3>");
				}
		out.print("<h3>성별: "+gender+"</h3>"
				+ "<h3>종교: "+rel+"</h3>"
				+ "<h3>자기소개: "+intro+"</h3>"
				+ "<h3>QueryString: "+req.getQueryString()+"</h3>"
				+ "</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 값 받아오기
		req.setCharacterEncoding("UTF-8");	// POST는 받아오는 값에도 인코딩 타입명시해야 한글 안 깨짐
//		String id = req.getParameter("id");
//		String pwd = req.getParameter("pwd");
//		String name = req.getParameter("name");
//		String[] hobby = req.getParameterValues("hobby"); // 받아오는 값이 여러개일때 배열로 받아온다.  
//		String gender = req.getParameter("gender");
//		String rel = req.getParameter("religion");
//		String intro = req.getParameter("introduction");
		
		//받아온 파라미터로 출력하기
		resp.setContentType("text/html;charset=UTF-8");	
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>Query 문자열</title></head>"
				+ "<body><h1>Post방식 요청</h1>"
//				+ "<h3>ID: "+id+"</h3>"
//				+ "<h3>비밀번호: "+pwd+"</h3>"
//				+ "<h3>이름: "+name+"</h3>"
				);
//		
//		for(String hob : hobby) {
//			out.print("<h3>취미: "+hob+"</h3>");
//		}
//		
//		out.print("<h3>성별: "+gender+"</h3>"
//				+ "<h3>종교: "+rel+"</h3>"
//				+ "<h3>자기소개: "+intro+"</h3>");
		
		ServletInputStream input = req.getInputStream();
		int len = req.getContentLength();
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len);
		String str = new String(buf);
				
		out.print("<h3>QueryString: "+str+"</h3>"
				+ "</body></html>");
		out.close();
	}
}
