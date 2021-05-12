package com.edu.test.stateless;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context2")
public class ServletContextTest2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletContext의 값을 지정, obj1, obj2를 여기서 생성하려고 한다. 
		ServletContext sc = this.getServletContext();
		
		ShareObject so1 = new ShareObject();
		so1.setCount(100);
		so1.setStr("객체공유테스트 -1");
		sc.setAttribute("data1", so1);
		
		ShareObject so2 = new ShareObject();
		so2.setCount(200);
		so2.setStr("객체공유테스트 -2");
		sc.setAttribute("data2", so2);
	}

}
