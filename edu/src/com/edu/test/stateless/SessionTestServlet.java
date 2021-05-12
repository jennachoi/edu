package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String param = req.getParameter("p");
		String msg = null;
		HttpSession session = null;

		if(param.equals("create")) {
			session = req.getSession(); // getSession() : 세션정보가 있으면 불러오고 없으면 새로운 세션정보를 생성해서 리턴해준다.
			if (session.isNew()) {
				msg = "새로운 세션 객체가 생성됨.";
			} else {
				msg = "기존의 세션 객체가 리턴됨.";
			}
		} else if(param.equals("delete")) {
			session = req.getSession(false);
			if(session != null) {
				session.invalidate();		// 존재하는 세션 객체 삭제하는 작업. 
				msg = "세션객체 삭제작업 완료";
			} else {
				msg = "삭제할 세션 존재하지 않음.";
			}
		}
		
		out.print("<h2>" + msg + "</h2>");
		out.close();
	}
}
