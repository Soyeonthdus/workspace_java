<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.util.*, java.util.*" %>
<%@ page import = "com.google.gson.Gson" %>
<%@ page import = "org.apache.ibatis.session.*" %>
    
<%
	//스크립틀릿
	//out.print("jsonMemberList페이지");
MyBatisCommonFactory mcf = new MyBatisCommonFactory(); //혼자서 4개가 하는 일을 다 함
 
//DBConnectionMgr dbMgr = new DBConnectionMgr();
//Connection 					con = null;
//PreparedStatement pstmt = null;
//ResultSet 							rs = null; /*커서를 통해 뺴오는 것*/

	List<Map<String,Object>> memList = null;
	StringBuilder sql = new StringBuilder();
	//sql.append("Select mem_no, mem_id, mem_name From member"); //쿼리문 xml에서 가져다 쓸거임
	
		SqlSessionFactory sqlSessionFactory = null; //xml과 연결하기 위해 필요함
		//SqlSession으로 commit과 rollback 지원 받음
		//	org.apache.ibatis.session.SqlSession sqlSession = null;
		SqlSession sqlSession = null; //commit과 rollback 할 때 필요함
		Map<String, Object> pmap = new HashMap<>();
		pmap.put("mem_no",0);
	try {
		sqlSessionFactory = mcf.getSqlSessionFactory();
		sqlSession = sqlSessionFactory.openSession();
		//member.xml에서 
		memList = sqlSession.selectList("getMemberList", pmap); //id값
		
		
		//물리적으로 떨어져있는 오라클 서버에 연결해주는 통로
		//con = dbMgr.getConnection();
		//연결통로를 통해서 select문을 가져가고 오라클서버에게 요청하는 객체를 로딩
		//pstmt = con.prepareStatement(sql.toString());
		//오라클 서버의 커서를 조작할 객체 로딩
		//rs = pstmt.executeQuery();
		//memList = new ArrayList<>();
		//Map<String,Object> rmap = null;
		
		//while(rs.next()) {
			//rmap = new HashMap<>();
			//rmap.put("mem_no", rs.getInt("mem_no"));
			//rmap.put("mem_id", rs.getString("mem_id"));
			//rmap.put("mem_name", rs.getString("mem_name"));
			//memList.add(rmap);
		//}
		
		System.out.println(memList);
	}catch(Exception e) {
		e.printStackTrace();
	}/* finally {
		//사용한 자원을 반납하기 - 명시적으로 반납할 것 - 실행시점을 당기기 위해 - 튜닝팀의 권장사항
		dbMgr.freeConnection(con, pstmt, rs);
	} */
	Gson g = new Gson();
	String temp = null;
	temp = g.toJson(memList);
	out.print(temp);
%>