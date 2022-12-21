package test8_board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test8WriteForm")
public class Test8WriteFormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test8WriteFormServlet - doGet()");
		
		// test8_board 폴더의 writeForm.jsp 페이지로 포워딩
		// => 새 주소로 변경하지 않고, 기존 주소를 유지하기 위해 Dispatcher 방식 포워딩
		//    (http://localhost:8080/StudyServlet/Test8WriteForm)
		RequestDispatcher dispatcher = request.getRequestDispatcher("test8_board/writeForm.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}











