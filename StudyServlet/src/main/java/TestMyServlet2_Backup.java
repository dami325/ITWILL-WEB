import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/StudyServlet/myServlet2 주소를 매핑하기 위한 @WebServlet 어노테이션 설정
//@WebServlet("/myServlet2")
public class TestMyServlet2_Backup extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestMyServlet2 - doGet()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestMyServlet2 - doPost()");
	}
	
}
