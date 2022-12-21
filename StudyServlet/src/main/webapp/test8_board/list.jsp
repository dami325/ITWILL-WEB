<%@page import="test8_board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="test8_board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	<table border="1">
		<tr>
			<th width="50">번호</th>
			<th width="400">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
		</tr>
		<%
		// 서블릿 클래스에서 List.bo 서블릿 주소 처리 시 조회된 게시물 목록을
		// request.setAttribute() 메서드를 통해 "boardList" 라는 이름으로 저장되어 있음
		// => request.getAttribute() 메서드를 통해 가져올 수 있음
		List<BoardDTO> boardList = (List<BoardDTO>)request.getAttribute("boardList");
		
		// 향상된 for 문을 사용하여 List 객체 크기만큼 반복
		for(BoardDTO board : boardList) {
			%>
			<!-- BoardDTO 객체에 저장된 멤버변수 값(데이터)을 테이블에 표시 -->
			<tr>
				<td><%=board.getIdx() %></td>
				<!-- 게시물 제목 클릭 시 content.jsp 페이지로 이동(글번호(idx)를 파라미터로 전달) -->
				<td><a href="content.jsp?idx=<%=board.getIdx() %>"><%=board.getSubject() %></a></td>
				<td><%=board.getName() %></td>
				<td><%=board.getDate() %></td>
				<td><%=board.getReadcount() %></td>
			</tr>
			<%
		}
		%>
	</table>
	<div align="right">
		<input type="button" value="글쓰기" onclick="location.href='Test8WriteForm'">
	</div>
</body>
</html>












