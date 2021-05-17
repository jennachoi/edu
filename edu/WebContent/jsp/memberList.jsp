<%@page import="com.edu.test.stateless.Member"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/memberList.jsp</title>
</head>
<body>
	<jsp:useBean id="dao" class="com.edu.test.stateless.MemberDAO"></jsp:useBean>
	<h1>회원리스트</h1>
	<table border="1">
		<tr>
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>나이</th>
		</tr>
		<%
			//MemberDAO dao = new MemberDAO(); useBean 객체의 내용과 동일함 
			List<Member> list = dao.getMemberList();
			for (int i = 0; i < list.size(); i++) {
		%>
			<tr>
			<td><a href="memberInfo.jsp?memberId=<%=list.get(i).getMemberId() %>"><%=list.get(i).getMemberId() %></a></td>
			<td><%=list.get(i).getMemberPwd() %></td>
			<td><%=list.get(i).getMemberName() %></td>
			<td><%=list.get(i).getMemberAge() %></td></tr>
			<%
			}
			%>
	</table>

</body>
</html>