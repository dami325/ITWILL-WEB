<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 쓰기 폼</h1>
	<form action="WritePro" method="post">
		작성자 : <input type="text" name="name"><br>
		제목 : <input type="text" name="subject"><br>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>