<%@page import="member.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// member/idCheck.jsp
String id=request.getParameter("id");

//MemberDAO 객체 생성 후 checkId() 메서드를 호출하여 아이디 중복 확인
//=> 파라미터 : 아이디(id)    리턴타입 : boolean(isDuplicate)
MemberDAO dao = new MemberDAO();
boolean isDuplicate = dao.checkId(id);

String result="";
// 5단계
if(isDuplicate==true){
	//데이터 있음, 아이디 있음, 아이디 중복
	result="아이디 중복";
}else{
	//데이터 없음, 아이디 없음, 아이디 사용가능
	result="아이디 사용가능";
}
%>
<%=result%>