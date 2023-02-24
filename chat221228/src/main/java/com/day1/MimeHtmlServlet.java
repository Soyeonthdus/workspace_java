package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 java인데 브라우저에 출력할 수있는 자바다 : 화면을 그리는데 서블릿을 사용함 -> 마임타입때문에 가능하다
@WebServlet("/html.do?gubun = 2") //웹에서 접근 가능한 맵핑 주소 설정
public class MimeHtmlServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		String gubun = req.getParameter("gubun");
		if(gubun ==null) {
			res.setContentType("text/html ; charset=UTF-8");
			//메소드를 통해서 객체 생성하는 코드 - 고급
			PrintWriter out = res.getWriter();
			out.print("<h2>안녕 난 소연</h2>"); //HTML로 바꾸니까 태그없이 속성 적용 돼서 나옴
		}
		else {
			res.sendRedirect("./mimeHtmlResult.jsp");
		}
		
	}//end of throws
	
	
	
}//end of class
