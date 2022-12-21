<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//mainJson.jsp
BoardDAO dao=new BoardDAO();
//최근글 5개
ArrayList<BoardDTO> boardList=dao.selectBoardList(0, 5);

// json-simple-1.1.1.jar 설치
//json 변경
JSONArray bList=new JSONArray();
SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd");
for(int i=0;i<boardList.size();i++){
	BoardDTO dto=boardList.get(i);
	
	JSONObject board=new JSONObject();
	board.put("num", dto.getNum());
	board.put("name", dto.getName());
	board.put("subject", dto.getSubject());
	// 날짜=> 문자열 변경 yyyy.MM.dd
	board.put("date", format.format(dto.getDate()));
	
	// 배열 저장
	bList.add(board);
}
%>
<%=bList%>