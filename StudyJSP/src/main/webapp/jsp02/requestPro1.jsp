<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro1.jsp</h1>
	<h1>request 객체 예제(처리 페이지)</h1>
	<%
	/*
	requestForm1.jsp 페이지에서 submit 버튼 클릭 시
	form 태그 내의 데이터(= 폼 파라미터)가 request 객체에 모두 저장되고
	action 속성에 지정된 페이지로 이동(= 요청)하면서 데이터 전달됨
	=> 요청 관련 모든 정보는 request 객체가 관리(= JSP 가 자동으로 생성하는 객체 = 내장 객체)
	   따라서, request.메서드명() 형태로 request 객체에 접근 가능
	=> 요청받은 request 객체에 저장된 폼 파라미터 데이터를 가져오는 방법
	   1) request.getParameter("파라미터명"); // 단일 항목 데이터 가져오기(String 타입 리턴)
	   2) request.getParameterValues("파라미터명"); // 복수 항목 파라미터 가져오기(String[] 타입 리턴)
	=> 주의! 전달받은 파라미터가 존재하지 않을 경우(지정한 이름이 없을 경우) null 값이 리턴되고,
	   파라미터는 있으나 데이터가 없는 경우 널스트링("") 이 리턴됨
	*/
	
	// ------------------------------------------------------------------------------------
	// POST 방식으로 파라미터가 전달될 경우 한글 처리
	// => 반드시 응답페이지(데이터를 실제로 가져와서 사용하는 곳)에서 설정
	// => request 객체의 setCharacterEncoding() 메서드를 호출하여 "UTF-8" 지정
	request.setCharacterEncoding("UTF-8");
	// => 단, 반드시 파라미터값 가져오는 코드(request.getParameter() 등)보다 먼저 수행해야함
	// -------------------------------------------------------------------------------------
	
	// 1. 파라미터 중 파라미터명(name 속성값)이 "name" 인 값 가져와서 String 타입 strName 에 저장
	String strName = request.getParameter("name");
	// 스크립틀릿 내에서 웹브라우저에 데이터 출력할 경우 out.print() 또는 out.println() 사용
// 	out.println("이름 : " + strName + "<br>");
	
	// 2. 파라미터 중 파라미터명(name 속성값)이 "age" 인 값 가져와서 String 타입 strAge 에 저장
	String strAge = request.getParameter("age");
// 	out.println("나이 : " + strAge + "<br>");
	
	// 3. 파라미터 중 파라미터명(name 속성값)이 "gender" 인 값 가져와서 String 타입 strGender 에 저장
	String strGender = request.getParameter("gender");
// 	out.println("성별 : " + strGender + "<br>");	
	
	// 4. 파라미터 중 파라미터명(name 속성값)이 "hobby" 인 값 가져와서 String 타입 strHobby 에 저장
// 	String strHobby = request.getParameter("hobby");
	// 주의! 복수개의 데이터가 하나의 파라미터로 전달되는 경우(ex. 체크박스)
	// getParameter() 메서드를 사용하면 하나의 데이터(첫번째)만 가져올 수 있음
	// 따라서, getParameter() 메서드 대신 getParameterValues() 메서드를 호출하여
	// 복수개의 동일한 이름의 파라미터를 String[] 타입 배열로 리턴받아 처리해야함
// 	out.println("취미 : " + strHobby + "<br>"); // 취미 중 첫번째로 체크된 항목만 출력됨
	String[] strHobbies = request.getParameterValues("hobby");
// 	out.println("취미 : " + strHobbies + "<br>");
	// => 주의! 체크박스 항목을 하나도 체크하지 않을 경우 "hobby" 파라미터가 없게 됨
	//    따라서, 미 체크시 strHobbies 변수에는 null 값이 저장된다!
	
	%>
	
	<table border="1">
		<tr>
			<td>이름</td><td><%=strName %></td>
		</tr>
		<tr>
			<td>나이</td><td><%=strAge %></td>
		</tr>
		<tr>
			<td>성별</td><td><%=strGender %></td>
		</tr>
		<tr>
			<!-- strHobbies 배열 접근 시 최대 3개의 항목이 저장되지만, 3개 미만일 수도 있음(오류 발생 가능성 있음) -->
			<!-- 즉, 3개 미만으로 체크할 경우 ArrayIndexOutOfBoundsException 예외(오류) 발생함 -->
<%-- 			<td>취미</td><td><%=strHobbies[0] %>,<%=strHobbies[1] %>,<%=strHobbies[2] %></td> --%>
			<!-- 반드시, 반복문을 사용하여 배열의 크기만큼 반복하면서 배열에 접근해야한다! -->
			<td>취미</td>
			<td>
				<%
				// 스크립틀릿 내에서 strHobbies 배열 내의 모든 요소에 접근하는 for문 사용하여 반복 출력
				// => 주의! 체크박스 항목을 하나도 체크하지 않을 경우 strHobbies 변수에 null 저장되고
				//    strHobbies.length 를 통해 접근할 경우 NullPointerException 이라는 예외(오류) 발생함
// 				for(int i = 0; i < strHobbies.length; i++) {
// 					out.println(strHobbies[i] + " ");
// 				}
				%>
				
				<%-- 
				만약, strHobbies 가 null 이면 자바스크립트를 사용하여
				"취미 선택 필수!" 메세지를 출력한 후 이전페이지로 돌아가기 
				--%>
<%-- 				<%if(strHobbies == null) { %> --%>
					<%-- 스크립틀릿 외부이므로 자바스크립트 사용 가능 --%>
					<script type="text/javascript">
// 						alert("취미 선택 필수!");
// 						history.back();
					</script>
<%-- 				<%}%> --%>

				<%
				// 체크 항목이 하나도 없을 경우 "없음" 을 출력하고, 하나라도 있을 경우에만 반복
				if(strHobbies == null) { // 체크항목이 하나도 없을 경우
					out.println("없음");
				} else { // 체크항목이 하나라도 있을 경우
					// 반복문을 사용하여 배열 내의 요소 차례대로 접근
					for(int i = 0; i < strHobbies.length; i++) {
						out.println(strHobbies[i] + " ");
					}
				}
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="뒤로가기" onclick="history.back()"></td>
		</tr>
	</table>
	
</body>
</html>













