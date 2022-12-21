package test8_board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test8List")
public class Test8ListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test8ListServlet - doGet()");
		
		// BoardDAO 객체 생성 후 select() 메서드를 호출하여 글목록 조회
		// => 파라미터 : 없음   리턴타입 : List<BoardDTO>(boardList)
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> boardList = dao.select();
		
		// 글목록 페이지로 글목록이 저장된 List 객체 전달을 위해 request 객체에 List 객체 저장
		request.setAttribute("boardList", boardList);
		
		// test8_board 폴더의 list.jsp 페이지로 포워딩 
		// => request 객체에 저장된 데이터를 공유해야하며, 기존 서블릿 주소를 유지해야하므로
		//    Dispatcher 방식 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("test8_board/list.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}











