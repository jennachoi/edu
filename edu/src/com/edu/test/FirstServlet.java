package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") // 어노테이션 방식
public class FirstServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()"); // init은 가장 처음 한번만 호출된다.
	}

//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service()");
//		// 여기에 필요한 내용들을 적어주면 된다. 서블릿이 원래 정의하고 서비스 순서대로가 아닌 개발자가 직접 정의할 수 있는 것.
//		res.getWriter().print("<h1>Hello</h1>");
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()");
	}

	@Override
	public void destroy() {
		System.out.println("destroy()"); // 서버가 끝날때 실행할 내용 적어주면 된다.
	}
}
