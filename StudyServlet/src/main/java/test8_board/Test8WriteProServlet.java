package test8_board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test8WritePro")
public class Test8WriteProServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test8WriteProServlet - doPost()");
		
		// POST 방식 요청에 대한 한글 처리
		request.setCharacterEncoding("UTF-8");

		// writeForm.jsp 페이지로부터 전달받은 폼파라미터(작성자, 비밀번호, 제목, 내용)를 가져와서
		// 변수에 저장한 후 출력하기
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("작성자 : " + name);
		System.out.println("패스워드 : " + passwd);
		System.out.println("제목 : " + subject);
		System.out.println("내용 : " + content);
		
		
		// BoardDTO 객체 생성 및 데이터 저장
		BoardDTO board = new BoardDTO();
		board.setName(name);
		board.setPasswd(passwd);
		board.setSubject(subject);
		board.setContent(content);
		
		// BoardDAO 객체 생성 및 insert() 메서드를 호출하여 글쓰기 작업 요청
		// => 파라미터 : BoardDTO 객체   리턴타입 : int(insertCount)
		BoardDAO dao = new BoardDAO();
		int insertCount = dao.insert(board);
		
		// 작업 완료 결과 판별
		// 성공 시(insertCount > 0) 글목록 표시를 위해 Test8List 서블릿 주소 요청
		// => Redirect 방식 포워딩(Test8ListServlet 클래스에서 요청 처리)
		// 실패 시 콘솔창에 "글쓰기 실패!" 출력
		if(insertCount > 0) {
			response.sendRedirect("Test8List");
		} else {
			System.out.println("글쓰기 실패!");
		}
		
	}

}











