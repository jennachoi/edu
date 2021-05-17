<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example18.jsp</title>
</head>
<body>
<h3>useBean 활용</h3>
<form action="example17.jsp">
	<!-- 파라미터 이름을 member 객체의 필드이름과 똑같이 지정해줘야함 -->
	ID: <input type="text" name="memberId"><br>
	PW: <input type="password" name="memberPwd"><br>
	Name: <input type="text" name="memberName"><br>
	Age: <input type="number" name="memberAge"><br>
	<input type="submit">
</form>
</body>
</html>