<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL/exam01.jsp</title>
</head>
<body>
	<%
		BookBean book = new BookBean();
		book.setAuthor("홍길동");
		book.setPublisher("홍출판사");
		book.setTitle("의적");
		request.setAttribute("Hong", book);
	%>

<!-- 자바 대신 태그로 적어주는 방법. 타입 체크 하지 않아도 알아서 들어가서 좋음. 
c:set 변수 설정
c:out 출력
c:remove 변수 삭제
          변수이름 	  변수에 담아줄 내용  -->
	<c:set var="name" value="123"></c:set>
	<c:out value="${name }"></c:out> <!-- out.print(""); 같은 것. 자바를 쓰지 않고 태그로 쓸때 -->
	<p>${name eq "123"}</p>
	<c:remove var="name"/>
	
	<c:set var="title" value="${Hong.title }"></c:set>
	<c:out value="${title} "></c:out>
	<p>"${Hong }"</p>
	
	<c:set var="author">${Hong.author }</c:set>
	<c:out value="${author }"></c:out>
	
	<c:set var="pub"><%=book.getPublisher() %></c:set>
	<c:out value="${pub }"/>
	
</body>
</html>