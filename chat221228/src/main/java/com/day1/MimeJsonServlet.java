package com.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//서블릿은 java인데 브라우저에 출력할 수있는 자바다 : 화면을 그리는데 서블릿을 사용함 -> 마임타입때문에 가능하다
@WebServlet("/json.do") //웹에서 접근 가능한 맵핑 주소 설정 
//@WebServlet이 있으면 Web.xml 필요 없음
public class MimeJsonServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		res.setContentType("application/json ; charset=UTF-8");
		
		//메소드를 통해서 객체 생성하는 코드 - 고급
		PrintWriter out = res.getWriter();
		List<Map<String,Object>> mList = new ArrayList<>();
		
		Map<String, Object> rmap = new HashMap<>();
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
		
		//그냥 찍으면 key와 value가 : 이 아니라 = 로 연결되어 있어서 오류가 난다
		//이를 방지하기 위해 Gson 사용
		Gson g = new Gson();
		String temp = g.toJson(mList);
		out.print(temp);
	}
	
	
	
}
