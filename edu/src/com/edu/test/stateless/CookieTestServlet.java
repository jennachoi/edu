package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Cookie c1 = new Cookie("id", "guest");
		c1.setPath("/"); 	// 전체경로 어디를 가더라도 이 쿠키를 활용하겠다는 의미~!
		resp.addCookie(c1); // addCookie(c1) : 클라이어트쪽으로 쿠키 c1을 전송
		
		Cookie c2 = new Cookie("code", "0001");
		c2.setMaxAge(2 * 60);	// 이 쿠키가 얼마나 갈건지? 3 * 60 * 60 = 3시간.
		c2.setPath("/");
		resp.addCookie(c2);

		Cookie c3 = new Cookie("subject", "java");
		c3.setMaxAge(10 * 24 * 60 * 60);	// 10일동안 유효하게 
		c3.setPath("/");
		resp.addCookie(c3);
	
		out.print("쿠키 전송 완료");
		out.close();
	}
}
