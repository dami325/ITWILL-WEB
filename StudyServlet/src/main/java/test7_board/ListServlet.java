package test7_board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/List")
public class ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ListServlet - doGet()");
		
		// WritePro -> List 서블릿 주소 요청 시 Redirect 방식으로 포워딩 했으므로
		// 주소가 변경되고 기존 request 객체가 유지되지 않음
//		String name = request.getParameter("name");
//		String subject = request.getParameter("subject");
//		System.out.println("작성자 : " + name); 
//		System.out.println("제목 : " + subject);
		// => 따라서, 이전 request 객체에 저장된 데이터가 유지되지 않으므로 null 값 출력됨
		
		
		// 글목록에 필요한 데이터를 DB 로부터 조회했다고 가정
		// => 다음 페이지로 포워딩 시 저장된 데이터를 공유하기 위해 
		//    request 객체의 setAttribute() 메서드를 호출하여 데이터 저장
		request.setAttribute("name", "홍길동");
		request.setAttribute("subject", "안녕하세요");
		
		
		// list.jsp 페이지로 포워딩
		// => 이전 요청 주소인 List 서블릿 주소를 유지하기 위해(list.jsp 노출하지 않기 위해)
		//    Dispatcher 방식으로 포워딩
//		RequestDispatcher dispatcher = request.getRequestDispatcher("test7_board/list.jsp");
//		dispatcher.forward(request, response);
		
		response.sendRedirect("test7_board/list.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ListServlet - doPost()");
	}
	
	

}













