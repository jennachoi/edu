package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher2")
public class DispatcherTest2Serv extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String str = (String) req.getAttribute("data1");    // 넘겨준 값을 캐스팅 해서 받아오기
		String par = (String) req.getAttribute("data2");    // data2라는 key의 value를 가져오겠다. 
		
		out.print("<h3>Dispatcher 수행2</h3>");
		out.print("<h3>응답결과: " + str + "</h3>");
		out.print("<h3>응답결과: " + par + "</h3>");
		
		out.close();
	}

}
