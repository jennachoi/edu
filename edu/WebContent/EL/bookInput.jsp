<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/EL/bookInput.jsp</title>
</head>
<body>
	<form action="bookProc.jsp" method="post">
		책제목: <input type="text" name="title"><br>
		책저자: <input type="text" name="author"><br>
		출판사: <input type="text" name="publisher"><br>
		<input type="submit">
	</form>
	
	<a href="bookProc.jsp?title=홍길동전서">상세정보</a>

</body>
</html>