package test8_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// study_jsp3.board 테이블의 데이터 처리 작업을 담당하는 BoardDAO 클래스 정의
public class BoardDAO {
	
	// board 테이블 글쓰기 작업(INSERT)을 수행하는 insert() 메서드 정의
	// => 파라미터 : 게시물 정보 = BoardDTO 객체(board)     리턴타입 : int(insertCount) 
	public int insert(BoardDTO board) {
		int insertCount = 0; // 리턴할 데이터를 저장하는 변수 선언
		
		Connection con = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// board 테이블에 폼 파라미터 사용하여 글쓰기 작업 수행(INSERT)
			// => 단, 글번호(idx)는 가장 큰 번호 + 1 값으로 새로 설정
			//	  작성일(date)은 데이터베이스의 now() 함수 사용
			//	  조회수(readcount)는 기본값인 0 으로 설정
			
			// DBCP 를 활용하여 이미 커넥션풀에 생성되어 있는 Connection 객체를 JdbcUtil 클래스가 관리하므로
			// JdbcUtil 클래스의 getConnection() 메서드를 호출하여 커넥션풀의 커넥션 객체를 가져오기
			con = JdbcUtil.getConnection();
			
			// 1) 새 글 번호 계산
			// => board 테이블의 모든 레코드의 idx 컬럼값 중 가장 큰 값 조회(데이터베이스 max() 함수 활용)
			int idx = 1; // 새 글 번호를 저장할 변수 선언(기본값 1)

			// 3단계. SQL 구문 작성 및 전달
			// => MySQL 의 MAX(컬럼명) 함수를 사용하면 특정 컬럼에서 가장 큰 값 조회 가능
			String sql = "SELECT MAX(idx) FROM board";
			pstmt = con.prepareStatement(sql);

			// 4단계. SQL 구문 실행 및 결과 처리
			rs = pstmt.executeQuery();

			// 다음 레코드가 존재할 경우 첫번째 컬럼 값(INT 타입) + 1 값을 idx 변수에 저장
			if(rs.next()) {
				idx = rs.getInt(1) + 1;
			}
			// -------------------------------------------------------------------------------------------
			// 2) 글 등록(INSERT) 작업 수행
			// 3단계. SQL 구문 작성 및 전달
			// => 작성일(6번 파라미터 : now() 함수 호출), 조회수(7번 파라미터 : 기본값 0)
			sql = "INSERT INTO board VALUES (?,?,?,?,?,now(),0)";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, idx); // 새 글 번호
			// 작성자, 패스워드, 제목, 내용은 BoardDTO 객체에 저장되어 있으므로
			// BoardDTO 객체의 Getter 메서드를 호출하여 각 데이터를 꺼내서 setXXX() 메서드에 전달
			pstmt2.setString(2, board.getName()); // 작성자
			pstmt2.setString(3, board.getPasswd()); // 패스워드
			pstmt2.setString(4, board.getSubject()); // 제목
			pstmt2.setString(5, board.getContent()); // 내용

			// 4단계. SQL 구문 실행 및 결과 처리
			// => INSERT 구문 실행 시 리턴되는 값(int 타입)을 insertCount 변수에 저장 후 리턴
			insertCount = pstmt2.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insert() : " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 별도로 정의된 close() 메서드를 호출하여 자원을 반환할 객체를 파라미터로 전달
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(con);
		}
		
		// INSERT 구문 실행 결과를 리턴받아 저장한 변수 insertCount 값을 리턴
		return insertCount;
	} // insert() 메서드 끝
	
	
	// 글목록 조회 작업을 수행하는 select() 메서드 정의
	// => 파라미터 : 없음    리턴타입 : java.util.List(boardList) => 제네릭타입 BoardDTO
	public List<BoardDTO> select() {
		// 글목록 조회 결과를 리턴할 List 타입 변수 선언
		// 1개 레코드가 저장된 BoardDTO 객체 복수개를 하나의 묶음으로 관리할 List 타입
		List<BoardDTO> boardList = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 0 ~ 2단계 - 공통작업
			con = JdbcUtil.getConnection();
			
			// 3단계. SQL 구문 작성 및 전달
			// => board 테이블의 모든 레코드 조회(idx 컬럼 기준 내림차순 정렬)
			String sql = "SELECT * FROM board ORDER BY idx DESC";
			pstmt = con.prepareStatement(sql);
			
			// 4단계. SQL 구문 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			// 복수개의 레코드(복수개의 BoardDTO 객체)를 저장하는 ArrayList 객체 생성
			// => 제네릭타입 BoardDTO 지정
			// => 반복문 실행 전 먼저 객체 생성한 후 반복문 내에서 BoardDTO 객체 저장 필수!
			boardList = new ArrayList<BoardDTO>();
			
			// 조회 결과 테이블을 반복문을 통해 레코드 반복 접근
			while(rs.next()) {
				// 1개 게시물 정보를 저장하는 BoardDTO 객체(board) 생성
				BoardDTO board = new BoardDTO();
				// ResultSet 객체의 1개 레코드 각 컬럼 데이터를 BoardDTO 객체에 저장
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setPasswd(rs.getString("passwd"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setDate(rs.getDate("date"));
				board.setReadcount(rs.getInt("readcount"));
				
				// 1개 레코드가 저장된 BoardDTO 객체를 ArrayList 객체에 추가
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		return boardList;
	}
	
} // BoardDAO 클래스 끝













