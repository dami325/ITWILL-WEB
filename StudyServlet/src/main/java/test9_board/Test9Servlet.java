package test9_board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL 패턴이 xxx.bo 로 끝나는 모든 서블릿 주소 요청을 처리하는 클래스
@WebServlet("*.bo")
public class Test9Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식 요청 시 자동으로 호출되는 메서드 => 공통 메서드 doProcess() 호출
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 요청 시 자동으로 호출되는 메서드 => 공통 메서드 doProcess() 호출
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET or POST 방식 상관없이 공통으로 작업을 처리할 메서드
		// => *.bo 패턴에 의해 GET 또는 POST 방식 요청을 한꺼번에 전달받게 되기 때문에
		System.out.println("Test9Servlet - doProcess() 메서드 호출됨!");
		
		// POST 방식 요청에 대한 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// ===========================================================================
		// 주소표시줄에 입력되어 있는 URL 에서 서블릿 주소 부분을 가져와서
		// 각 서블릿 주소 판별을 통해 수행해야할 동작을 결정해야한다.
		// 따라서, 요청 정보가 저장된 request 객체에서 서블릿 주소 추출이 필요함!
		// ex) WriteForm.bo 일 때와 WritePro.bo 일 때의 동작이 다르므로
		//     URL 에서 서블릿 주소(프로젝트명 뒷부분의 /xxx.bo) 를 추출한 후
		//     문자열 비교를 통해서 각 서블릿 주소 판별 작업을 수행해야함
		// ---------------------------------------------------------------------------
		// 0. 참고) 요청 주소(URL) 전체 추출(가져오기)
//		String requestURL = request.getRequestURL().toString();
//		System.out.println("requestURL : " + requestURL);
		// requestURL : http://localhost:8080/StudyServlet/List.bo
		// => 단, 서버마다 IP 주소 또는 포트번호 등이 달라질 수도 있으므로
		//    요청 URL 전체를 문자열로 판별하는 작업은 효율적이지 못함
		// => 공통 부분을 제외한 나머지(= 서블릿 주소) 부분만 추출 필요
		
		// 1. 요청 주소 중 URI 부분(/프로젝트명/서블릿주소) 추출
//		String requestURI = request.getRequestURI();
//		System.out.println("requestURI : " + requestURI);
		// 프토로콜://서버주소:포트번호 부분을 제외한 나머지 부분 추출
		// => /StudyServlet/List.bo
		
		// 2. 요청 주소 중 컨텍스트 경로(/프로젝트명) 추출
//		String contextPath = request.getContextPath();
//		System.out.println("contextPath : " + contextPath);
		// contextPath : /StudyServlet
		
		// 3. 요청 주소 중 서블릿 주소 부분(/서블릿주소) 추출
		// => requestURI 와 contextPath 를 가공하여 추출
		// => 힌트 : "/StudyServlet/List.bo" - "/StudyServlet" = "/List.bo"
		// 1) contextPath 에 해당하는 부분을 널스트링("")으로 치환 
		//    - String 클래스의 replace() 메서드 활용
//		String command = requestURI.replace(contextPath, "");
//		System.out.println("command : " + command);
		
		// 2) "/서블릿주소" 부분에 대한 부분 문자열 추출 - String 클래스의 substring() 메서드 활용
		// => "/StudyServlet/List.bo" 주소 중에서 /List.bo 부분을 추출해야하므로
		//    /StudyServlet 문자열의 길이를 알아내면 /List.bo 문자열의 시작인덱스로 활용 가능
		//    즉, contextPath 의 길이를 시작 인덱스 번호로 활용하여 requestURI 의 끝까지 추출
		// ex) "/StudyServlet/List.bo" 문자열의 /List.bo 시작인덱스가 13 이므로
		//     /StudyServlet 문자열의 길이(13)를 시작인덱스로 활용
//		String command = requestURI.substring(contextPath.length());
//		System.out.println("command : " + command);
		
		// --------------------------------------------------------------------------------------
		// 위의 1 ~ 3번 과정을 하나의 메서드로 압축하여 제공 - request 객체의 getServletPath()
		String command = request.getServletPath();
		System.out.println("command : " + command);
		// --------------------------------------------------------------------------------------		
		// 추출된 서블릿 주소(command)를 if문을 사용하여 문자열 비교를 수행하고
		// 각 주소에 따른 액션(작업) 요청(주의! 서블릿 주소 앞 "/" 기호 반드시 포함해야함!)
		if(command.equals("/Main.bo")) {
			System.out.println("메인페이지 이동!");
			
			// 메인 페이지 표시를 위한 View 페이지(*.jsp) 로 포워딩
			// 별도의 비즈니스 로직(= DB 작업)이 불필요하므로 뷰페이지로 바로 연결
			// => 이 때, JSP 페이지의 URL 이 주소 표시줄에 노출되지 않고
			//    이전의 요청 주소인 서블릿 주소(/Main.bo)를 그대로 유지해야하므로
			//    Dispatcher 방식으로 포워딩
			RequestDispatcher dispatcher = request.getRequestDispatcher("test9_board/main.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/WriteForm.bo")) {
			System.out.println("글쓰기 뷰페이지 이동!");
			
			// 뷰페이지(test9_board/writeForm.jsp)로 바로 이동 => Dispatcher 방식
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("test9_board/writeForm.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/WritePro.bo")) {
			System.out.println("글쓰기 비즈니스 로직!");
			
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
			// 성공 시(insertCount > 0) 글목록 표시를 위해 List.bo 서블릿 주소 요청
			// => Redirect 방식 포워딩
			// 실패 시 콘솔창에 "글쓰기 실패!" 출력
			if(insertCount > 0) {
				response.sendRedirect("List.bo");
			} else {
				System.out.println("글쓰기 실패!");
			}
		} else if(command.equals("/List.bo")) {
			System.out.println("글목록!");
			
			// BoardDAO 객체 생성 후 select() 메서드를 호출하여 글목록 조회
			// => 파라미터 : 없음   리턴타입 : List<BoardDTO>(boardList)
			BoardDAO dao = new BoardDAO();
			List<BoardDTO> boardList = dao.select();
			
			// 글목록 페이지로 글목록이 저장된 List 객체 전달을 위해 request 객체에 List 객체 저장
			request.setAttribute("boardList", boardList);
			
			// test9_board 폴더의 list.jsp 페이지로 포워딩 
			// => request 객체에 저장된 데이터를 공유해야하며, 기존 서블릿 주소를 유지해야하므로
			//    Dispatcher 방식 포워딩
			RequestDispatcher dispatcher = request.getRequestDispatcher("test9_board/list.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}














