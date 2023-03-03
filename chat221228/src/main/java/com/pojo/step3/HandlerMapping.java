package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class HandlerMapping {
	static Logger logger = Logger.getLogger(HandlerMapping.class);

/*
 * @param upmu[](upmu[0] - 업무명[폴더명], upmu[1] - 메소드명, 기능명, 페이지이름, 분기)
 * @param request -1-1, 1-2와는 다르게 인터페이스를 implements 하지 않는다
 * @param response
 * 질문? 요청객체와 응답객체를 어디서 받아오지? -> 서블릿에서 받아와야지...추상적인 답변 
 * 어떻게? 어디에서? - ActionSupport에서 리턴타입은? Object
 * @return Object
 * */
	public static Object getController(String[] upmu, HttpServletRequest req, HttpServletRequest res)
				throws ServletException, IOException{
			logger.info(upmu[0] + "," + upmu[1]);
			Controller3 controller = null;
			String path = null;
			ModelAndView mav = null;
			return null;
	}
}
