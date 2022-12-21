

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 단일 주소 매핑을 동시에 복수개 주소로 기술할 경우
// @WebServlet({ "주소1", "주소2", ..., "주소n"})
@WebServlet({ "/myServlet6", "/myServlet6Post" })
public class TestMyServlet6 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
	}

}











