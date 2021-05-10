package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/secondServlet", "/second" }) // 두가지 url로 주소 호출가능
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlet() {
		super();
	}
	
	// init() -> request, response의 값을 만들어서 -> service(request, response) service의 매개값으로 던져주기 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		
//		Enumeration<String> en = request.getHeaderNames(); // 요청정보에header names 값을 요청해봄
//		while (en.hasMoreElements()) {// hasMoreElements : 가지고 올 요소들이 있는지 물어봄. 없으면 false 츨력
//			String key = en.nextElement();
//			String val = request.getHeader(key);
//			System.out.println(key + ", " + val);
//		}
		
		// http://localhost/edu/second?name=Hong&age=20 url 주소
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		response.sendRedirect("index.html"); // 다른페이지로 redirect 하겠다
		PrintWriter out = response.getWriter();
//		response.setHeader("name", "Hong"); // header를 만들어줌. 
//		ArrayList<String> col = (ArrayList<String>) response.getHeaderNames(); // 응답정보가 가지고 있는 header 값들
//		for(String key : col) {
//			String val  = response.getHeader(key);
//			System.out.println(key + ", " + val);
//		}
		out.print("<h1>" + name + "</h1>");
		out.print("<h1>" + age + "</h1>");
	
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
