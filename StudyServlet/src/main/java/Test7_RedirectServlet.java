

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectServlet")
public class Test7_RedirectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet - doGet()");
		
		// test7_redirect_dispatcher.jsp 페이지에서 입력받은 아이디, 파라미터 가져와서
		// 변수에 저장 후 출력
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + passwd);
		// --------------------------------------------------------------------------
		// 현재 서블릿 클래스에서 작업 완료 후 test7_redirect_result.jsp 페이지로 포워딩
		// => Redirect 방식 포워딩 수행
		// => response 객체의 sendRedirect() 메서드를 호출하여 포워딩 할 페이지 전달
		// => 현재 서블릿 주소 : http://localhost:8080/StudyServlet/redirectServlet
		//    (따라서, 현재 위치에서 test7_redirect_result.jsp 를 지정하면 webapp 폴더의 파일 지정)
		//    (즉, webapp/test7_redirect_result.jsp 페이지로 포워딩)
		response.sendRedirect("test7_redirect_result.jsp");
		
		// Redirect 방식 포워딩 특징
		// 1. 포워딩 시 지정한 주소가 웹브라우저 주소표시줄에 표시됨(= 요청받은 새 주소로 바뀜)
		// => http://localhost:8080/StudyServlet/redirectServlet 주소에서
		//    http://localhost:8080/StudyServlet/test7_redirect_result.jsp 주소로 변경됨
		// 2. 이전 요청 시 생성된 request 객체가 유지되지 않음(= 새 request 객체가 생성됨)
		// => 이전에 저장되어 있던 파라미터 등은 더 이상 존재하지 않게 됨
		//    (= 새 페이지에서 request 객체의 데이터에 접근 불가능)
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}








