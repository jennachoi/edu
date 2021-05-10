package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String met = req.getMethod();
		
		String name = req.getParameter("name");
		String id = req.getParameter("user_id");
		String age = req.getParameter("user_age");
		
		PrintWriter out = resp.getWriter();
		
		if (met.equals("GET")) {
			out.print("<table border='1'>"
					+ "<tr><td>이름</td><td>" + name + "</td></tr>"
					+ "<tr><td>아이디</td><td>" + id + "</td></tr>"
					+ "<tr><td>나이</td><td>" + age + "</td></tr>");
		} else {
			out.println("<ul><li>"
					+ name + "</li><li>"
					+ age + "</li><li>"
					+ id + "</li></ul>");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("user_id");
		String age = request.getParameter("user_age");

		PrintWriter out = response.getWriter();
		out.print("<table border='1'>"
				+ "<tr><td>이름</td><td>" + name + "</td></tr>"
				+ "<tr><td>아이디</td><td>" + id + "</td></tr>"
				+ "<tr><td>나이</td><td>" + age + "</td></tr>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
