<%@page import="test9_board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 목록</h1>
	<table border="1">
		<tr>
			<th width="50">번호</th>
			<th width="400">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
		</tr>
		
		<%-- JSTL 의 c:forEach 태그를 사용하여 request 객체의 boardList 객체만큼 반복 --%>
		<c:forEach var="board" items="${boardList }">
			<%-- BoardDTO 객체에 저장된 멤버변수 값(데이터)을 테이블에 표시(EL 의 ${board.xxx} 사용) --%>
			<tr>
				<td>${board.idx }</td>
				<!-- 게시물 제목 클릭 시 content.jsp 페이지로 이동(글번호(idx)를 파라미터로 전달) -->
				<td><a href="content.jsp?idx=${board.idx }">${board.subject }</a></td>
				<td>${board.name }</td>
				<%-- 
				JSTL 의 포맷 관련 기능을 제공하는 라이브러리를 통해 날짜 형식 변경
				=> 반드시 taglib 를 통해 JSTL 의 fmt 라이브러리 추가 필수!
				=> <fmt:formatDate value="${날짜객체}" pattern="날짜패턴">
				   (날짜 패턴은 SimpleDateFormat 에서 사용하는 패턴문자열과 동일함) 
				ex) <fmt:formatDate value="${board.date }" pattern="yy-MM-dd"/>
				    => board 객체의 date 날짜 데이터를 "연도 2자리-월 2자리-일 2자리" 로 변경
				--%>
				<td><fmt:formatDate value="${board.date }" pattern="yy-MM-dd"/></td>
				<td>${board.readcount }</td>
			</tr>
		</c:forEach>
	</table>
	<div align="right">
		<input type="button" value="글쓰기" onclick="location.href='WriteForm.bo'">
	</div>
</body>
</html>












