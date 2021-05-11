package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdditionalInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html>"
				+ "<head><title>Request 정보</title></head>"
				+ "<body>"
				+ "<h1>추가정보</h1>"
				+ "Request Method: " + req.getMethod()
				+ "<br>Path Info: " + req.getPathInfo()
				+ "<br>Path Translated: " + req.getPathTranslated()
				+ "<br>Query String: " + req.getQueryString()
				+ "<br>Content Length: " + req.getContentLength()
				+ "<br>Content Type: " + req.getContentType()
				+ "</body></html>"
				);
	}
}
