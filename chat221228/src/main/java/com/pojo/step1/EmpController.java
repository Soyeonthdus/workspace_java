package com.pojo.step1;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//emp 테이블을 이용할 것
//SELECT empno, ename, job, hiredate FROM emp
public class EmpController implements Action {
Logger logger = Logger.getLogger(EmpController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		return null;
	}

}
