

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcherServlet")
public class Test7_DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DispatcherServlet - doGet()");
		
		// test7_redirect_dispatcher.jsp 페이지에서 입력받은 아이디, 파라미터 가져와서
		// 변수에 저장 후 출력
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + passwd);
		
		// ------------------------------------------------------------------------------
		// 현재 서블릿 클래스에서 작업 완료 후 test7_dispatcher_result.jsp 페이지로 포워딩
		// => Dispatcher 방식 포워딩 수행
		// 1. request 객체의 getRequestDispatcher() 메서드를 호출하여 포워딩 할 페이지 전달
		//    => 리턴타입 : javax.servlet.RequestDispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("test7_dispatcher_result.jsp");
		
		// 2. RequestDispatcher 객체의 forward() 메서드를 호출하여 포워딩 작업 수행
		//    => 파라미터 : request 객체, response 객체
		dispatcher.forward(request, response);
		
		// Dispatcher 방식 포워딩 특징
		// 1. 포워딩 시 지정한 주소가 웹브라우저 주소표시줄에 표시되지 않고
		//    이전의 요청 주소가 그대로 유지됨(주소표시줄의 주소가 변경되지 않음)
		// => http://localhost:8080/StudyServlet/dispatcherServlet 주소가 그대로 유지됨
		// 2. 이전 요청 시 생성된 request 객체를 포워딩 시점에서 함께 전달하므로
		//    포워딩 후에도 기존 request 객체(response 포함)가 그대로 유지됨
		//    즉, 원래 저장되어 있던 파라미터 등의 값도 그대로 유지됨(= 새 페이지에서 공유됨) 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}








