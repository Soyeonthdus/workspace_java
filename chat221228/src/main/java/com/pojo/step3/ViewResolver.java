package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ViewResolver {
	Logger logger = Logger.getLogger(ViewResolver.class);
	
	//생성자
	public ViewResolver() {}
	public ViewResolver(HttpServletRequest req, HttpServletResponse res, String[] pageMove) 
			throws ServletException, IOException {
		String path = pageMove[1];
		//webapp바라본다
		if ("redirect".equals(pageMove[0])) {
            res.sendRedirect(path);
         } 
		else if("forward".equals(pageMove[0])){
            RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
            view.forward(req, res);
         }
		//setViewName(~~~~);
		//WEB-INF/views/~~~~~~.jsp를 바라본다
         else {
        	 logger.info("else로 빠짐");
        	 path = pageMove[0]+"/"+pageMove[1];
        	 RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/"+path+".jsp");
	         view.forward(req, res);
         }
	}//end of ViewResolver(req, res, pageMove)
	
}//end of class
