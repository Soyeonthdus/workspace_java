package mvc.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.log4j.Logger;

import model.vo.Board;

public class BoardDao {
	Logger logger = Logger.getLogger(BoardDao.class);
	
	public int insertBoard(Connection conn, Board board ) {
		logger.info("insertBoard 호출 성공"+conn+board);
		int result =0;
		//Connection con = null;
		PreparedStatement pstmt = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO khboard(id,title,writer,content)");
		sql.append("VALUES(seq_khboard.nextval,?,?,?)");
		try {
			//true면 insert후에 자동 커밋해주세요 - 디폴트가 true
			con.setAutoCommit(false);
			con=dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pMap.get("title").toString());//사용자가 화면에 입력한 제목 담기
			pstmt.setString(2, pMap.get("writer").toString());//사용자가 화면에 입력한 작가담기
			pstmt.setString(3 pMap.get("content").toString());//사용자가 화면에 입력한 내용담기
			pstmt = conn.prepareStatement(sql.toString());
			result = pstmt.setString(3,pMap.get())
			pstmt.setString(1, board.title);
			pstmt.setString(2, board.writer);
			pstmt.setString(3, board.content);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} finally {
			dbMgr.freeConnection(conn, pstmt);
		}
		return result;
	}
}


