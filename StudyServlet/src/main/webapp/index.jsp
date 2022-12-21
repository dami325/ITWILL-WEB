<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<h3><a href="test1.jsp">test1.jsp 페이지로 이동</a></h3>
	<h3><a href="test2.jsp">test2.jsp 페이지로 이동</a></h3>
	<h3><a href="test3.jsp">test3.jsp 페이지로 이동</a></h3>
	<h3><a href="test4_servlet_life_cycle.jsp">test4_servlet_life_cycle.jsp 페이지로 이동</a></h3>
	<h3><a href="test5.jsp">test5.jsp 페이지로 이동</a></h3>
	<h3><a href="test6.jsp">test6.jsp 페이지로 이동</a></h3>
	<h3><a href="test7_redirect_dispatcher.jsp">test7_redirect_dispatcher.jsp 페이지로 이동</a></h3>
	<hr>
	<h3>test8_board 게시판 연습(서블릿)</h3>
	<!-- Test8WriteForm 서블릿 요청 시 Test8WriteFormServlet 클래스 매핑 작업 수행 -->
	<!-- Test8WriteFormServlet 클래스에서 test8_board 폴더의 writeForm.jsp 페이지로 포워딩 -->
	<input type="button" value="글쓰기" onclick="location.href='Test8WriteForm'">
	
	<input type="button" value="글목록" onclick="location.href='Test8List'">
</body>
</html>













