package test7_board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WriteForm")
public class WriteFormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WriteFormServlet - doGet()");
		
		// test7_board 폴더 내의 writeForm.jsp 페이지로 포워딩 
		// => 포워딩 될 주소(writeForm.jsp)를 숨기기 위해 기존 서블릿 주소 유지해야하므로
		//    Dispatcher 방식으로 포워딩
//		RequestDispatcher dispatcher = request.getRequestDispatcher("writeForm.jsp");
		// => 주의! 현재 요청 서블릿 주소가 http://localhost:8080/StudyServlet/WriteForm 일 경우
		//    실제 jsp 파일이 위치한 폴더인 test7_board 폴더에 접근하여 파일을 지정해야함
		RequestDispatcher dispatcher = request.getRequestDispatcher("test7_board/writeForm.jsp");
		dispatcher.forward(request, response);
		// => Dispatcher 방식으로 포워딩 했을 경우
		//    기존 서블릿 주소인 http://localhost:8080/StudyServlet/WriteForm 주소가 변경되지 않음
		//    즉, 포워딩 되는 실제 jsp 파일명이 노출되지 않음
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WriteFormServlet - doPost()");
	}

}










