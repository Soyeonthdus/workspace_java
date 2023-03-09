package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board3Logic {
	Logger logger = Logger.getLogger(Board3Logic.class);
	Board3Dao boardDao = new Board3Dao();
	
	/**
	 * 글 목록 출력
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출" + pMap);
		List<Map<String, Object>> bList = null;
		bList = boardDao.boardList(pMap);
		
		return bList;
	}
	
	/**
	 * 글 상세보기
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> boardDetailList(Map<String, Object> pMap) {
		logger.info("boardDetailList 호출" + pMap);
		List<Map<String, Object>> bList = null;
		bList = boardDao.boardList(pMap);
		int bm_no = Integer.parseInt(pMap.get("bm_no").toString());
		boardDao.hitCount(bm_no);
		return bList;
	}

	/**
	 * 새 글쓰기
	 * @param pMap
	 * @return
	 */
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert 호출" + pMap);
		int result = 0;
		int bm_no = 0;
		int bm_group = 0;
		bm_no = boardDao.getBNo();
		pMap.put("bm_no", bm_no);
		
		// Map안에서 꺼낸다는 건 화면에서 넘어온 값이라는 뜻
		if(pMap.get("bm_group")!=null) {
			bm_group = Integer.parseInt(pMap.get("bm_group").toString());
		}
		
		// 댓글쓰기인 경우
		/*
		 * UPDATE board_master_t
		 * SET bm_step = bm_step + 1
		 * WHERE bm_group =:g
		 * AND bm_step >:s;
		 */
		if(bm_group > 0) {
			logger.info("댓글쓰기 로직 호출");
			boardDao.bStepUpdate(pMap);
			pMap.put("bm_pos", Integer.parseInt(pMap.get("bm_pos").toString())+1);
			pMap.put("bm_step", Integer.parseInt(pMap.get("bm_step").toString())+1);
		}
		
		// 새글쓰기인 경우 -> 그룹번호 채번 포함
		else {
			logger.info("새글쓰기 로직 호출 => " + bm_group);
			bm_group = boardDao.getBGroup();
			pMap.put("bm_group", bm_group);
			pMap.put("bm_pos", 0);
			pMap.put("bm_step", 0);
		}
		
		result = boardDao.boardInsert(pMap);
		
		// 첨부파일이 존재할 경우
		if(pMap.get("bs_file") != null && pMap.get("bs_file").toString().length() > 1) {
			pMap.put("bm_no", bm_no);
			// 현재 첨부파일은 하나만 담는 것으로 가정하고 처리함
			pMap.put("bs_seq", 1);
			int result2 = 0;
			result2 = boardDao.boardSInsert(pMap);
			logger.info(result2); // 1이면 등록 성공(첨부파일 추가 성공)
		}
		
		return result;
	}
	
	/**
	 * 글 수정
	 * @param pMap
	 * @return
	 */
	public int boardUpdate(Map<String, Object> pMap) {
		logger.info("boardUpdate 호출" + pMap);
		int result = 0;
		result = boardDao.boardMUpdate(pMap);
		return result;
	}
	
	/**
	 * 글 삭제
	 * @param pMap
	 * @return
	 */
	public int boardDelete(Map<String, Object> pMap) {
		logger.info("boardDelete 호출" + pMap);
		int result = 0;
		result = boardDao.boardMDelete(pMap);
		return result;
	}
}