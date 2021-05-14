<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- %@ 페이지 전체에 대한 정보를 알려주는 것--> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/example01.jsp</title>
</head>
<body>
<%! // 필드(멤버변수)선언, 메소드 선언
	String name;
	public int sum(int a, int b) {
		return a + b;
	}
	int result = sum(10, 20);
%>
<%
	// 자바영역임
	String user = request.getParameter("name");
	if (user == null) {
		user = "Guest";
	}
%>
<h1>Hello <%=user%></h1>
<H2>결과: <%=result %></H2>
</body>
</html>