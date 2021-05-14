<%@page import="com.edu.test.stateless.Member"%>
<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logInfo.jsp</title>
</head>
<body>
<%
	//db 조회 후 가져온 member이름, 나이를출력
	//없으면 해당 사용자 없음
	
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO dao = new MemberDAO();
	Member mem = new Member();
	mem = dao.checkInfo(id, pwd);
	
	String name = mem.getMemberName();
	int age = mem.getMemberAge();

	if ( name == null && age == 0 ) {
		request.setAttribute("err", "사용자 없음");
		RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
		rd.forward(request, response);
		return;
	}
	
%>
	<H3>이름: <%=name %></H3>
	<H3>나이: <%=age %></H3>
</body>
</html>