<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL/exam04.jsp</title>
</head>
<body>
	<%
		List<BookBean> bookList = new ArrayList<>();
		bookList.add(new BookBean("title1", "author1", "pub1"));
		bookList.add(new BookBean("title2", "author2", "pub2"));
		request.setAttribute("list", bookList);
		//for (BookBean book : bookList) {
		//	out.print(book.getTitle());
		//	out.print(book.getAuthor());
		//}
		
		//for(int i = 1; i < 10; i++) {
		//}
		
	%>
	<h3>forEach 반복문</h3>
	<c:forEach items="${list }" var="book">
		<p>${book.title } / ${book.author } / ${book.publisher }</p>
	</c:forEach>

	<h3>forEach 반복문의 중첩</h3>	
	<c:forEach begin="2" end="9" var="val"> 
		<c:forEach begin="1" end="9" var="num">
			<p>${val} * ${num } = ${val * num }</p>	
		</c:forEach>
	</c:forEach>
		
</body>
</html>