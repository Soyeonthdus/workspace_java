package com.pojo.step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board3Dao {
	Logger logger = Logger.getLogger(Board3Dao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();

	/**
	 * 게시글 목록 출력
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출");
		List<Map<String, Object>> bList = null;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			bList = sqlSession.selectList("boardList", pMap);
			logger.info(bList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}

	/**
	 * 새 게시글 쓰기
	 * @param pMap
	 * @return
	 */
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert 호출");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			// insert이지만 update로 하는 이유는 리턴타입이 Object이기 때문이다
			// 메소드 이름은 상관없이 해당 쿼리문을 id로 찾기 때문이다
			result = sqlSession.update("boardMInsert", pMap);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	/**
	 * 글 group 채번
	 * @return
	 */
	public int getBGroup() {
		int result = 0;
		logger.info("getBGroup 호출");
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("getBGroup", "");
			logger.info(result); // 채번한 글그룹번호
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 글 no 채번
	 * @return
	 */
	public int getBNo() {
		int result = 0;
		logger.info("getBNo 호출");
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.selectOne("getBNo", "");
			logger.info(result); // 채번한 글번호
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 글 step 업데이트
	 * @param pMap
	 */
	public void bStepUpdate(Map<String, Object> pMap) {
		logger.info("bStepUpdate 호출");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("bStepUpdate", pMap);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of bStepUpdate
	
	/**
	 * 글 조회수 업데이트
	 * @param bm_no - 글번호 가져오기
	 */
	public void hitCount(int bm_no) {
		logger.info("hitCount 호출");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("hitCount", bm_no);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of hitCount
	
	/**
	 * 글 수정하기
	 * @param pMap - 사용자가 입력한 값 받아옴
	 */
	public int boardMUpdate(Map<String, Object> pMap) {
		logger.info("boardMUpdate 호출");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardMUpdate", pMap);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // end of boardMUpdate
	
	/**
	 * 글 삭제하기
	 * @param pMap
	 * @return
	 */
	public int boardMDelete(Map<String, Object> pMap) {
		logger.info("boardMDelete 호출");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			int bm_no = 0;
			if(pMap.get("bm_no")!=null) {
				bm_no = Integer.parseInt(pMap.get("bm_no").toString());
			}
			result = sqlSession.update("boardMDelete", bm_no);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // end of boardMDelete

	/**
	 * 첨부파일 등록하기
	 * @param pMap
	 * @return
	 */
	public int boardSInsert(Map<String, Object> pMap) {
		logger.info("boardSInsert 호출");
		int result = 0;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			// insert이지만 update로 하는 이유는 리턴타입이 Object이기 때문이다
			// 메소드 이름은 상관없이 해당 쿼리문을 id로 찾기 때문이다
			result = sqlSession.update("boardSInsert", pMap);
			if(result == 1) {
				sqlSession.commit();
			}
			logger.info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
}