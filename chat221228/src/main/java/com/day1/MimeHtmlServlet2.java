package com.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//서블릿을 경유하여 응답페이지를 jsp로 가져가는 실습

//최초 mimeHtmlResult.jsp를 직접 호출하는 것이 아니라
// /day1/html2.do로 요청했을 때 아래 코드 39번을 만나서 
//mimeHtmlResult.jsp로 주소창이 변경되는 것을 관찰한 뒤
//서블릿에서 세션에 담은 정보를 MimeHtmlResult.jsp 페이지에서
//유지되는지 확인하는 실습이다

//서블릿은 java인데 브라우저에 출력할 수있는 자바다 : 화면을 그리는데 서블릿을 사용함 -> 마임타입때문에 가능하다
@WebServlet("/day1/html2.do") //웹에서 접근 가능한 맵핑 주소 설정
public class MimeHtmlServlet2 extends HttpServlet {
	Logger logger = Logger.getLogger(MimeHtmlServlet2.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		logger.info("doGet호출");
		//요청객체로 세션객체를 생성할 수 있음
		HttpSession session = req.getSession();
		
		String myName = new String("박소연"); 
		int age = 28; 
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", "tomato");
		rmap.put("mem_pw", "111");
		rmap.put("mem_name", "토마토");
		
	
	if(rmap != null) {
		rmap.clear(); //휴지통 비우기
	}
	
	List<Map<String,Object>> mList = new ArrayList<>();
		rmap = new HashMap<>();
		rmap.put("mem_id","tomato");
		rmap.put("mem_pw","111");
		rmap.put("mem_name","토마토");
		mList.add(rmap);
		
		rmap = new HashMap<>();
		rmap.put("mem_id","kiwi");
		rmap.put("mem_pw","222");
		rmap.put("mem_name","키위");
		mList.add(rmap);
		
		rmap = new HashMap<>();
		rmap.put("mem_id","banana");
		rmap.put("mem_pw","333");
		rmap.put("mem_name","바나나");
		mList.add(rmap);
		
		session.setAttribute("myName", myName);
		session.setAttribute("age", age);
		session.setAttribute("rmap", rmap);
		session.setAttribute("mList", mList);
		res.sendRedirect("./mimeHtmlResult.jsp"); //페이지 전환
		
	}//end of throws
	
	
	
}//end of class
