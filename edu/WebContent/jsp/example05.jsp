<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example05.jsp</title>
</head>
<body>
	<H1>Include 지시자 사용.</H1>
	<%=application.getAttribute("welcomeMsg").toString()%>
	<%
		out.print("<h3>" + request.getAttribute("result").toString() + "</h3>");
	%>

	<!-- 아래 두개의 결과값은 똑같지만, 첫번째는 표준액션태그로 HTML에 JSP 태그를 사용 -->
	<jsp:include page="copyright.jsp"></jsp:include>
	<%--@ include file="copyright.jsp" --%>

</body>
</html>