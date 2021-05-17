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

%>
<%
	//String 객체는 equals로 비교
	if(request.getMethod().equals("POST")) { // POST 방식 -> 로그인
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Member mem = dao.checkInfo(id, pwd);

		if ( mem == null || mem.getMemberId() == null ) {
			out.print("사용자 없음");
		} else { 
			session.setAttribute("info", mem);
			out.print("<h3>나이: " + mem.getMemberAge() + "</h3>");
			out.print("<h3>이름: " + mem.getMemberName() + "</h3>");
			}
	}else { // GET 방식 -> 로그아웃
		session.invalidate();
		out.print("로그아웃 됨");
		
	}
%>
</body>
</html>