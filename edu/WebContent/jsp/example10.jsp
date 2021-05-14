<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/jsp/example10.jsp</title>
</head>
<body>
	<%
	String rid = null;
	String name = null;
	int age = 0;

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	if (id == null) {
		id = (String) session.getAttribute("id");
	}
	if (pwd == null) {
		pwd = (String) session.getAttribute("pwd");
	}
	if (id.isEmpty() || pwd.isEmpty()) { // IDpwd가 비어있다면 다시 로그인 페이지로 포워드
		request.setAttribute("err", "아이디와 비밀번호를 입력하세요");
		RequestDispatcher rd = request.getRequestDispatcher("logInOut.jsp");
		rd.forward(request, response);
		return;
	}

	//로그인 세션정보 조회
	if (session.isNew() || session.getAttribute("id") == null) {// 이미 있는 로그인처리는 false 출력
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
		session.setAttribute("name", "홍길동");
		session.setAttribute("age", 15);
		out.print("로그인 작업 완료.");
	} else {
		out.print("이미 로그인 중입니다.");
		rid = (String) session.getAttribute("id");
		name = (String) session.getAttribute("name");
		age = (int) session.getAttribute("age");
	}
	%>
	<h3>아이디 :<%=id%></h3>
	<h3>비밀번호 :<%=pwd%></h3>
	<h3>Welcome :<%=name%></h3>
</body>