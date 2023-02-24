package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class DeptManager extends HttpServlet{
	Logger logger = Logger.getLogger(DeptManager.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		logger.info("[[ doGet호출 성공]]");
		String u_deptno = req.getParameter("deptno");
		String u_dname = req.getParameter("dname");
		String u_loc = req.getParameter("loc");
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.print(u_deptno+","+u_dname+","+u_loc);
		}
		@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			
		}

}
