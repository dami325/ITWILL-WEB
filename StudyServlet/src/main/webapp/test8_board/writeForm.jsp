<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<!-- form 태그 액션을 Test8WritePro 로 지정, POST 방식 지정 -->
	<!-- 
	test8_board 패키지의 Test8WriteProServlet 클래스를 통해 서블릿 매핑 수행하고
	전달받은 파라미터(작성자, 비밀번호, 제목, 내용) 을 변수에 저장 후 출력
	-->
	<form action="Test8WritePro" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required="required"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="10" cols="20" required="required"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기">
					<input type="reset" value="초기화">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>












