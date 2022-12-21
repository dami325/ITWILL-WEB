

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test5/myServlet")
public class TestMyServlet5 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet5 - doGet()");
		
		// 메서드 파라미터로 HttpServletRequest 객체와 HttpServletResponse 객체가 자동으로 전달됨
		// => JSP 페이지에서 사용하던 request, response 객체와 동일한 객체
		// test5.jsp 페이지에서부터 요청 받을 때 전달받은 파라미터값(이름, 나이) 가져오기
		// => request 객체의 getParameter() 메서드 사용
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		// test5_result.jsp 페이지로 포워딩(이동)
		// => 주의! 현재 서블릿 주소가 "프로젝트명/test5/myServlet" 이므로
		//    현재 위치에서 test5_result.jsp 페이지를 지정할 때 아무 경로도 지정하지 않으면
		//    test5 폴더 내의 test5_result.jsp 페이지를 요청하게 되므로 404 Not found 에러 발생!
		// => 따라서, 서블릿 주소를 변경하거나 또는 현재 위치 기준 상대경로로 실제 위치를 지정해야함
//		response.sendRedirect("test5_result.jsp"); // webapp/test5/test5_result.jsp 페이지 요청(오류)
		response.sendRedirect("../test5_result.jsp"); // webapp/test5_result.jsp
		// => StudyServlet/test5 경로의 상위 경로인 StudyServlet/test5_result.jsp 페이지 요청
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet5 - doPost()");
		
		// test5.jsp 페이지에서부터 요청 받을 때 전달받은 파라미터값(이름, 나이) 가져오기
		// => request 객체의 getParameter() 메서드 사용
		// => 단, POST 방식 요청의 경우 한글 파라미터 처리를 위한 설정 필수!
		request.setCharacterEncoding("UTF-8"); // POST 방식 한글 처리
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		response.sendRedirect("../test5_result.jsp");
	}

}










