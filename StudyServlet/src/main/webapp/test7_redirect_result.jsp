<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test7_redirect_result.jsp</h1>
	<!-- 
	Redirect 방식 포워딩 특징
	1. 포워딩 시 지정한 주소가 웹브라우저 주소표시줄에 표시됨(= 요청받은 새 주소로 바뀜)
	=> http://localhost:8080/StudyServlet/redirectServlet 주소에서
	   http://localhost:8080/StudyServlet/test7_redirect_result.jsp 주소로 변경됨
	2. 이전 요청 시 생성된 request 객체가 유지되지 않음(= 새 request 객체가 생성됨)
	=> 이전에 저장되어 있던 파라미터 등은 더 이상 존재하지 않게 됨
	   (= 새 페이지에서 request 객체의 데이터에 접근 불가능)
	-->
	
	<!-- 이전 요청에서 전달받은 아이디(id), 패스워드(passwd) 파라미터 출력하기 -->
<%-- 	<h3>아이디 : <%=request.getParameter("id") %></h3> --%>
<%-- 	<h3>패스워드 : <%=request.getParameter("passwd") %></h3> --%>
	
	<!-- EL 을 사용하여 파라미터 출력해보기 -->
	<h3>아이디 : ${param.id }</h3>
	<h3>패스워드 : ${param.passwd }</h3>
	<!-- 새로운 request 객체가 생성되어 이전에 저장되어 있던 파라미터 값에 접근 불가능하다! -->
</body>
</html>












