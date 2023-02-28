package com.pojo.step1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
/*
	FrontMVC11 -> Board1Controller -> Board1Logic -> Board1Dao -> Mybatis Layer
	MyBatis가 실질적인 코드를 줄여주는 부분은 어디인가요?
	1) 커넥션 연결 - 단 오라클 서버에 대한 정보는 제공해줘야 함
	: 오라클 드라이버 클래스
	MyBatis
	: 오라클 서버의 URL정보 - 멀티티어에서 유리한 thin드라이버 방식, 계정이름과 비번
 */

public class Board1Dao {
	Logger logger = Logger.getLogger(Board1Dao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	
	public List<Map<String, Object>> getBoardList() {
		logger.info("getBoardList 호출");
		SqlSessionFactory sqlSessionFactory = null; 
		SqlSession sqlSession = null; 
		//여기서는 null로하는 이유가 어차피 로직클래스에서 인스턴스화를 해두었기 때문이다
		//NPE는 발생하지 않을 것임
		List<Map<String, Object>> boardList = null;
		try {
			//오라클 서버에 대한 정보를 가진 MyBatisConfig.xml문서를 읽는다 
			// -> MyBatisCommonFactory가 sqlSessionFactory().build(resource)
			//MyBatisCommonFactory 에서 처리된 결과를 getter메소드를 통해 주입 받음
			sqlSessionFactory = mcf.getSqlSessionFactory();
			//34번에서 생성된 객체가 제공하는 openSession()가 SqlSession객체 생성함
			sqlSession = sqlSessionFactory.openSession();
			//sqlSession은 쿼리문 요청이 가능한 insert(), update(), delete(), selectOne, selectMap등을 제공함
			boardList = sqlSession.selectList("getBoardList", null);
			logger.info(boardList); 
		} catch (Exception e) {
			logger.info(e.toString());
		}
		return boardList;
	}
}
