<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/bookOutput.jsp</title>
</head>
<body>
<%
	BookBean book = (BookBean) request.getAttribute("book");
%>
<h1>정상적으로 처리되었습니다.</h1>
<p>책제목 : ${book.title }</p><H3><%=book.getTitle()%></H3>
<p>책저자 : ${book.author }</p><H3><%=book.getAuthor()%></H3>
<p>출판사 : ${book.publisher }</p><H3><%=book.getPublisher()%></H3>
<p>toString : ${book }</p>
</body>
</html>