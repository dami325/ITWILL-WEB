<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test7_dispathcer_result.jsp</h1>
	<!-- 
	Dispatcher 방식 포워딩 특징
	1. 포워딩 시 지정한 주소가 웹브라우저 주소표시줄에 표시되지 않고
	   이전의 요청 주소가 그대로 유지됨(주소표시줄의 주소가 변경되지 않음)
	=> http://localhost:8080/StudyServlet/dispatcherServlet 주소가 그대로 유지됨
	2. 이전 요청 시 생성된 request 객체를 포워딩 시점에서 함께 전달하므로
	   포워딩 후에도 기존 request 객체(response 포함)가 그대로 유지됨
	   즉, 원래 저장되어 있던 파라미터 등의 값도 그대로 유지됨(= 새 페이지에서 공유됨) 
	-->
	
	<!-- 이전 요청에서 전달받은 아이디(id), 패스워드(passwd) 파라미터 출력하기 -->
<%-- 	<h3>아이디 : <%=request.getParameter("id") %></h3> --%>
<%-- 	<h3>패스워드 : <%=request.getParameter("passwd") %></h3> --%>
	
	<!-- EL 을 사용하여 파라미터 출력해보기 -->
	<h3>아이디 : ${param.id }</h3>
	<h3>패스워드 : ${param.passwd }</h3>
	<!-- 
	Dispatcher 방식으로 포워딩 했으므로 이전 request 객체가 유지되어
	새로 포워딩 된 현재 페이지에서도 request 객체를 통해 이전 파라미터 값에 접근 가능하다! 
	-->
</body>
</html>











