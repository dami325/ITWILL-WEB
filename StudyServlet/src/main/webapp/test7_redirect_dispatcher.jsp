<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test7_redirect_dispatcher.jsp</h1>
	<!-- "redirectServlet" 서블릿 주소 요청에 대한 RedirectServlet 클래스의 doGet() 메서드 호출 -->
	<form action="redirectServlet" method="get">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="passwd"><br>
		<input type="submit" value="로그인(Redirect)">
	</form>
	
	<!-- "dispatcherServlet" 서블릿 주소 요청에 대한 DispatcherServlet 클래스의 doGet() 메서드 호출 -->
	<form action="dispatcherServlet"  method="get">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="passwd"><br>
		<input type="submit" value="로그인(Dispatcher)">
	</form>
	
	<hr>
	<input type="button" value="글쓰기" onclick="location.href='WriteForm'">
	<input type="button" value="글목록" onclick="location.href='List'">
	
	
</body>
</html>









