package com.pojo.step3;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class parctice extends HttpServlet {
	Logger logger = Logger.getLogger(parctice.class);
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
			logger.info("doService 호출");
			
			String uri = req.getRequestURI();
	}
	
}//end of class
