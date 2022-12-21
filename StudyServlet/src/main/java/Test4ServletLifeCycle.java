

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLifeCycle")
public class Test4ServletLifeCycle extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 서블릿 클래스에 대한 요청(= 서블릿 주소 요청) 시 가장 먼저 자동으로 호출됨
		// => 서블릿 클래스에 대한 인스턴스 생성 후 인스턴스 초기화 목적으로 호출됨
		// => 서블릿 라이프 사이클 상에서 첫 요청에 대해 최초 1회만 실행됨(= 서버 중지 전까지)
		System.out.println("init() 메서드 호출됨");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// init() 메서드가 호출된 후 자동으로 호출됨
		// => 서블릿 클래스로 생성된 인스턴스 내에서 쓰레드가 1개 생성됨
		// => 요청이 발생할 때마다(= 서블릿이 호출될 때마다) 매번 호출됨(= 매번 쓰레드가 1개 생성됨)
		System.out.println("service() 메서드 호출됨");
		super.service(request, response);
	}
	
	@Override
	public void destroy() {
		// 서비스(= 톰캣 서버)가 중지(= 종료)될 때 자동으로 호출됨
		System.out.println("destroy() 메서드 호출됨");
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service() 메서드 호출 후에 GET 방식 요청일 경우 자동으로 호출됨
		System.out.println("Test4ServletLifeCycle - doGet()");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  service() 메서드 호출 후에 POST 방식 요청일 경우 자동으로 호출됨
		System.out.println("Test4ServletLifeCycle - doPost()");
	}


}
