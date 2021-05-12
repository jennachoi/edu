package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie3") // 쿠키로 몇번 방문했고,방문기록 갱신하는 서블릿임돠
public class CookieTest3Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int cnt = 0;
		Cookie[] list = req.getCookies();
		for (int i = 0; list != null && i < list.length; i++) {
			if(list[i].getName().equals("count")) {
				cnt = Integer.parseInt(list[i].getValue());
			}
		}
		cnt++;
		Cookie c = new Cookie("count", cnt + ""); // cnt + "" 하면 int인 cnt를 문자열로 바꿔준다
		c.setMaxAge(3600);
		resp.addCookie(c);
		
		PrintWriter out = resp.getWriter();
		out.print("<h2>방문횟수 : " + cnt + "</h2>");
		out.close();

	}

}