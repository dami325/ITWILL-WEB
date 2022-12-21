package test7_board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WritePro")
public class WriteProServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WriteProServlet - doGet()");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WriteProServlet - doPost()");
		
		// writeForm.jsp 페이지로부터 전달받은 파라미터(작성자, 제목) 가져와서 출력
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		System.out.println("작성자 : " + name);
		System.out.println("제목 : " + subject);
		
		// 글쓰기 작업 완료 후(완료했다고 가정) 글 목록 표시를 위해 List 서블릿 주소 요청
		// => 이전 request 객체 유지가 불필요하며, 새로운 요청을 발생시킴 
		//    (기존의 주소를 유지할 필요가 없으며, 기존 데이터 유지할 필요도 없음)
		// => 따라서, Redirect 방식의 포워딩 사용
		response.sendRedirect("List");
		// Redirect 방식의 포워딩 결과
		// 기존 요청 주소 : http://localhost:8080/StudyServlet/WritePro
		// 새 요청 주소 : http://localhost:8080/StudyServlet/List 로 변경됨
	}

}











