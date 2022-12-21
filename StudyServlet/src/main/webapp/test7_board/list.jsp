<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 목록</h1>
	<h3>이름 : <%=request.getAttribute("name") %></h3>
	<h3>제목 : <%=request.getAttribute("subject") %></h3>
	<hr>
	<h3>이름 : ${name }</h3>
	<h3>제목 : ${subject }</h3>
</body>
</html>





















