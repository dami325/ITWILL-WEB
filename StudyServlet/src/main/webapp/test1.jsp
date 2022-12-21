<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1.jsp</h1>
	
	<!-- 하이퍼링크를 사용하여 "myServlet" 서블릿 주소 요청 => GET 방식 요청 -->
	<h3><a href="myServlet">myServlet 서블릿 주소 요청(GET)</a></h3>
	
	<!-- form 태그를 활용한 서블릿 주소 요청 시 GET 방식은 method="get" 또는 생략 -->
	<form action="myServlet">
		<input type="submit" value="myServlet 서블릿 주소 요청(GET)">
	</form>
	
	<!-- form 태그를 활용한 서블릿 주소 요청 시 POST 방식은 method="post" 필수 -->
	<form action="myServlet" method="post">
		<input type="submit" value="myServlet 서블릿 주소 요청(POST)">
	</form>
	
	<!-- 매핑이 되어있지 않은 서블릿 주소 요청 시 HTTP 404 에러(Page not found) 발생  -->
	<form action="myServlet_fail" method="post">
		<input type="submit" value="myServlet_fail 서블릿 주소 요청(실패)">
	</form>
</body>
</html>


























