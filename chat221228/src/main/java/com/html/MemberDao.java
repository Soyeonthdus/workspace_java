package com.html;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.util.DBConnectionMgr;
import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

public class MemberDao {
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	Connection con = null;
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	PreparedStatement pstmt = null; //연결 통로를 통해서 SELECT문을 가져가고 오라클 서버에게 요청하는 객체로딩
	ResultSet rs = null; /*커서를 통해 뺴오는 것*/
	
	//json형식의 데이터를 받아오는데 ojdbc로 자바와 오라클 연결
	public String jsongetMemberList(){
		System.out.println("getMemberList 호출");
		List<Map<String,Object>> memList = null;
		StringBuilder sql = new StringBuilder();
		sql.append("Select mem_no, mem_id, mem_name From member");
		try {
			//물리적으로 떨어져있는 오라클 서버에 연결해주는 통로
			con = dbMgr.getConnection();
			//연결통로를 통해서 select문을 가져가고 오라클서버에게 요청하는 객체를 로딩
			pstmt = con.prepareStatement(sql.toString());
			//오라클 서버의 커서를 조작할 객체 로딩
			rs = pstmt.executeQuery();
			memList = new ArrayList<>();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("mem_no", rs.getInt("mem_no"));
				rmap.put("mem_id", rs.getString("mem_id"));
				rmap.put("mem_name", rs.getString("mem_name"));
				memList.add(rmap);
			}
			System.out.println(memList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//사용한 자원을 반납하기 - 명시적으로 반납할 것 - 실행시점을 당기기 위해 - 튜닝팀의 권장사항
			dbMgr.freeConnection(con, pstmt, rs);
		}
		Gson g = new Gson();
		String temp = null;
		temp = g.toJson(memList);
		return temp;
	}
	
	//값을 list에 넣어서 사용하려고 데이터 받아오는데 ojdbc로 자바와 오라클을 연결
	public List<Map<String,Object>> getMemberList(){
		System.out.println("getMemberList 호출");
		List<Map<String,Object>> memList = null;
		StringBuilder sql = new StringBuilder();
		sql.append("Select mem_no, mem_id, mem_name From member");
		try {
			//물리적으로 떨어져있는 오라클 서버에 연결해주는 통로
			con = dbMgr.getConnection();
			//연결통로를 통해서 select문을 가져가고 오라클서버에게 요청하는 객체를 로딩
			pstmt = con.prepareStatement(sql.toString());
			//오라클 서버의 커서를 조작할 객체 로딩
			rs = pstmt.executeQuery();
			memList = new ArrayList<>();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("mem_no", rs.getInt("mem_no"));
				rmap.put("mem_id", rs.getString("mem_id"));
				rmap.put("mem_name", rs.getString("mem_name"));
				memList.add(rmap);
			}
//			System.out.println(memList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//사용한 자원을 반납하기 - 명시적으로 반납할 것 - 실행시점을 당기기 위해 - 튜닝팀의 권장사항
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return memList;
	}
	
	//마이바티스로 자바와 오라클과 연결
	public List<Map<String,Object>> myBatisMemberList() {
		System.out.println("getMemberList 호출");
		//물리적으로 떨어져 있는 서버와 연결통로 확보 - 
		//MyBatisConfig.xml문서 정보(드라이버, 오라클서버의 URL, 계정정보 + 쿼리문을 담은 xml등록) 참조
		SqlSessionFactory sqlSessionFactory = null; //xml과 연결하기 위해 필요함
		//SqlSession으로 commit과 rollback 지원 받음
//		org.apache.ibatis.session.SqlSession sqlSession = null;
		SqlSession sqlSession = null; //commit과 rollback 할 때 필요함
		List<Map<String,Object>> memList = null;
		Map<String, Object> pmap = new HashMap<>();
		pmap.put("mem_no",2);
		
		String date = null;
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			//member.xml에서 
			memList = sqlSession.selectList("getMemberList", pmap); //id값
			//insert, update, delete시에 커밋 호출할 때 SqlSession을 사용함
			//sqlSession.commit();
			System.out.println(memList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return memList;
	}
	
	public List<MemberVO> myBatisMemberList2() {
		System.out.println("getMemberList 호출");
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		List<MemberVO> memList = null;
		Map<String, Object> pmap = new HashMap<>();
		pmap.put("mem_no",0);
		try {
			sqlSessionFactory = mcf.getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			memList = sqlSession.selectList("myBatisMemberList2", pmap); //id값
			System.out.println(memList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return memList;
	}
	
	public static void main(String args[]) {
		MemberDao memDao = new MemberDao();
//		memDao.getMemberList();
//		String temp = memDao.jsongetMemberList();
//		List<Map<String,Object>> memList =null;
		List<MemberVO> memList =null;
		memList = memDao.myBatisMemberList2();
		
		//Gson 사용
		Gson g = new Gson();
		String temp = g.toJson(memList);
		System.out.println(temp);
	}
	
}
