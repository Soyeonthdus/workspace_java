package mvc.kh;

import java.sql.Connection;
import java.util.Map;

import org.apache.log4j.Logger;

import model.vo.Board;

public class BoardService {
	Logger logger = Logger.getLogger(BoardService.class);
	BoardDao boardDao = new BoardDao();
	
	public int insertBoard(Connection conn, Board board) {
		logger.info("insertBoard 호출 성공");
		int result = 0;
		result = boardDao.insertBoard(conn, board);
		//result = 0
		return result;
	}
}
