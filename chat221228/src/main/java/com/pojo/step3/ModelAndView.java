package com.pojo.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
/*
 spring4 에서 제공되던 ModelAndView를 흉내내보기
 1) scope가 request이다
 2) 화면 이름을 정해준다 
 **/
public class ModelAndView {
	Logger logger = Logger.getLogger(ModelAndView.class);
	HttpServletRequest req = null;
	//캡슐화 - private - 캡슐화를 하면 반드시 getter/setter 필요하다 -> Lombok으로 대체가능
	private String viewName = null;
	List<Map<String, Object>> reqList = new ArrayList<>();
	
	//생성자
	public ModelAndView(){}
	public ModelAndView(HttpServletRequest req){
		this.req = req;
	}
	
	//메소드
	public void addObject(String name, Object obj) {
		req.setAttribute(name, obj);
		Map<String, Object> pMap = new HashMap<>();
		pMap.put(name, obj); //pMap에 파라미터도 들어오는 값을 담음
		reqList.add(pMap); //pMap을 reqList에 담아줌
	}
	
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	
}//end of class
