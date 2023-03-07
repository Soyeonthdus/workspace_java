package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//Model, ModelMap
public class HashMapBinder {
	//전역변수
	HttpServletRequest req = null;
	//생성자
	public HashMapBinder() {}
	//생성자 파라미터(지역변수)에 요청객체가 필요한 이유는 뭐죠?
	public HashMapBinder(HttpServletRequest req) {
		//생성자의 1역할 - 전변의 초기화
		this.req = req;
	}
	//메소드
	//어떤 페이지 어떤 상황에서 공통코드 재사용 가능하게 할 것인가?
	//업무별 요청 클래스에서 주입 받을 객체를 정해서 메소드의 파라미터로 전달 받음
	//전달 받은 주소번지 원본에 값을 담아 준다
	public void bind(Map<String, Object> pMap) {
		pMap.clear();
		//Enumeration은 인터페이스 인데 List,Map안에 뭔가 들어있는지 체크해줌
		//있으면 꺼내는 메소드까지 제공해줌 -> 
		Enumeration<String> en = req.getParameterNames(); //
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			pMap.put(key,  req.getParameter(key));
		}
	}
}
