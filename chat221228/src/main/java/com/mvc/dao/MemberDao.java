package com.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class MemberDao {
	//log4j모듈 활용해서 로그 출력 - 날짜와 시간, 클래스명, 라인번호, 링크
	//System.out.print() 대신에 사용함
	Logger logger = Logger.getLogger(MemberDao.class);
	//DAO클래스와 오라클 서버 사이에 MyBatis Layer에 필요한 설정 내용담기
	//member.xml의 물리적인 위치와 오라클 서버의 정보가 담긴 MyBatisConfig.xml의
	//정보를 IO로 읽어오는 코드가 포함되어있음
	//마이바티스는 쿼리문을 xml문서에 따로 관리한다
	//자바로 관리하는 것 보다 컴파일을 하지 않아도 되고 버전 관리에도 효과적임
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	public Map<String, Object> login(Map<String, Object> pMap){
		Map<String, Object> rmap = null;
		//MyBatisConfig.xml문서를 통해 스캔한 오라클 서버 정보로 연결통로를 확보(session)
		SqlSessionFactory sqlSessionFactory = null; 
		//위에서 SqlSessionFactory 생성되면 쿼리문을 요청하는 selectOne메소드가 필요한데
		//그 메소드를 제공하는 클래스 및 commit, rollback 지원
		SqlSession sqlSession = null; 
		try {
			//공통코드에서 연결통로 확보
			sqlSessionFactory = mcf.getSqlSessionFactory();
			//연결통로 확보로 생성된 객체로 SqlSession로딩하기
			sqlSession = sqlSessionFactory.openSession();
			//Map<String, Object> pMap = new HashMap<>();
			//pMap.put("mem_id", "tomato"); //아이디가 토마토이거나
			//pMap.put("mem_pw", "123"); //비번이 123인거
			rmap = sqlSession.selectOne("login", pMap);
			//request를 가지고 http세션을 만들다
			logger.info(rmap); //3건 모두 조회되어야함
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rmap;
	}
	public static void main(String args[]) {
		MemberDao mDao = new MemberDao();
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("mem_id", "tomato"); //사용자가 입력한 아이디
		pMap.put("mem_pw", "123"); // 사용자가 입력한 비번
		Map<String, Object> rMap = mDao.login(pMap);
		System.out.println(rMap);
	}
}
