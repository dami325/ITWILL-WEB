

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 어노테이션에 URL 매핑 시 단일 주소 매핑 외에
// 복수개의 주소를 하나의 패턴으로 묶어서 매핑도 가능함
// @WebServlet("*.패턴") => 해당 패턴으로 끝나는(xxx.패턴) URL 은 모두 현재 클래스로 요청 전송됨
// => 주의! 패턴 앞에 "/" 기호를 사용하지 않는다!
@WebServlet("*.do")
public class TestMyServlet6_2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*.do - get()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*.do - post()");
	}

}










