<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example12.jsp</title>
</head>
<body>
	<h1>Example12.jsp</h1>
	<%-- <%@ include file="example05.jsp" %> --%>
	<%!// 필드, 메소드를 선언할때 !
	public void work(String p, PageContext pc) {
		try {
			JspWriter out = pc.getOut();
			if (p.equals("include")) {
				out.print("include 전");
				pc.include("example05.jsp");
			} else if (p.equals("forword")) {
				pc.forward("example05.jsp");
			}
		} catch (Exception e) {
			System.out.println("오류발생");
		}
	}
	%>
	<%
	String p = request.getParameter("p");
	this.work(p, pageContext); // 사용자가 입력한 파라미터 값을 내용으로 넣어줌
	%>
</body>
</html>