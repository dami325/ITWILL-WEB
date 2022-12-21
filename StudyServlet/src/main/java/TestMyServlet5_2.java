

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test5/myServlet2")
public class TestMyServlet5_2 extends HttpServlet {
	// GET 방식과 POST 방식 요청에 대한 doGet(), doPost() 메서드에서 처리하는 작업은
	// 대부분 비슷하므로 별도의 메서드로 각각 작업을 처리하는 것보다는
	// 중복 제거를 위한 공통 메서드를 정의한 후 doGet(), doPost() 메서드에서 공통 메서드를 호출하여
	// 공통된 작업을 수행하는 것이 효율적이다!
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet5 - doGet()");
		
		// GET 방식 요청일 경우 자동으로 호출되는 메서드
		// => 공통으로 작업을 처리할 doProcess() 메서드 호출(파라미터는 동일하게 전달)
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet5 - doPost()");
		
		// POST 방식 요청일 경우 자동으로 호출되는 메서드
		// => 공통으로 작업을 처리할 doProcess() 메서드 호출(파라미터는 동일하게 전달)
		doProcess(request, response);
	}
	
	// GET 방식과 POST 방식 요청에 대한 공통 작업을 수행하는 doProcess() 메서드 정의
	// => 오버라이딩은 아니지만, 파라미터는 동일한 형식으로 지정
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet5 - doProcess()");
		
		// test5.jsp 페이지에서부터 요청 받을 때 전달받은 파라미터값(이름, 나이) 가져오기
		// => request 객체의 getParameter() 메서드 사용
		// => 단, POST 방식 요청에 대한 한글 파라미터 처리를 위한 설정만 추가하면 됨
		request.setCharacterEncoding("UTF-8"); // POST 방식 한글 처리
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		response.sendRedirect("../test5_result.jsp");
	}

}










