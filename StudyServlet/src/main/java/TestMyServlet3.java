import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 어노테이션 없이 서블릿 주소 매핑하는 방법 - web.xml(배포서술자) 활용
// 서블릿 주소 중 "/myServlet3" 가 요청되면 
// web.xml 에 매핑된 내용에 의해 현재 클래스(TestMyServlet3)가 실행됨
// => 인스턴스 생성 및 스레드 생성 후 doGet() 또는 doPost() 메서드 자동 호출됨
public class TestMyServlet3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet3 - doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet3 - doPost()");
	}
	
}












