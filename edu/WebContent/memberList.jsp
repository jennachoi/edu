<%@page import="java.util.List"%>
<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList.jsp</title>
<style>
table {
	border-collapse: collapse;
	width: 200px;
}
</style>
</head>
<body>
	<!-- 
	<ul>
//		List<Member> list = (List<Member>) request.getAttribute("memberList");

//		for (Member mem : list) {
//			out.print("<li>" + mem.getMemberId() + ", " + mem.getMemberName() + "</li>");
//		}
		%>
	</ul>
 -->
 	<h2>회원 리스트</h2>
 	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<%
		List<Member> list = (List<Member>) request.getAttribute("memberList");
		for (Member mem : list) {
			out.print("<tr><td>" + mem.getMemberId() + "</td><td>" + mem.getMemberName() + "</td><td>" + mem.getMemberAge()
			+ "</td></tr>");
		}
		%>
	</table>
</body>
</html>