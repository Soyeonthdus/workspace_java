package com.pojo.step2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServlet.class);
	private static final long serialVersionUID = 1L;
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 logger.info("doService 호출");
	    // /board/getBoardList.st1 -> web.xml -> url-pattern -> *.st1
	    String uri = req.getRequestURI(); // 주소창에 입력된 값 중 도메인과 포트 번호가 제외된 값만 담음
	    logger.info(uri); // /dept/getDeptList.st1
	    String context = req.getContextPath(); // -> server.xml
	    logger.info(context); // /dept/getDeptList.st1
	    String command = uri.substring(context.length() + 1); // context 정보만 제외된 나머지 경로 정보 담음
	    int end = command.lastIndexOf("."); //16 - st1 잘라내기 위해 사용
	    command = command.substring(0, end); // /board/getBoardList
	    String upmu[] = null; // upmu[0] = 업무명|폴더명, upmu[1] = 요청 기능 이름
	    upmu = command.split("/"); // /dept, getDeptList
	    //http://localhost:9000/board/getBoardList.st2
	    logger.info(upmu[0] + "," +upmu[1]);
		req.setAttribute("upmu", upmu);
		
		Board2Controller boardController = new Board2Controller();
		Object obj = "";
		obj = boardController.execute(req,res);
		//board2Controller.execute(req,res);
		if(obj != null) { //redirect: xxx.jsp or forward:xxx.jsp
			String pageMove[] = null;
			if(obj instanceof String) {
				if(((String) obj).contains(":")){
					logger.info(": 포함되어 있어요");
					pageMove = obj.toString().split(":");
				}else {
					logger.info(": 포함되어 있지 않아요");
					pageMove = obj.toString().split("/");
				}
				logger.info(pageMove[0]+","+pageMove[1]);
			}
			if(pageMove !=null) {
				String path = pageMove[1];
				if ("redirect".equals(pageMove[0])) {
		            res.sendRedirect(path);
		         } else if("forward".equals(pageMove[0])){
		            RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
		            view.forward(req, res);
		         }else {
		        	 path = pageMove[0]+","+pageMove[1];
		        	 RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/"+path+".jsp");
			            view.forward(req, res);
		         }
			}
		}//end of 페이지 이동처리에 대한 공통 코드 부분
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doGet호출");
		doService(req,res); // 브라우저의 주소창을 통해 요청하는 건 모두 get방식이다
		//톰캣서버에 url을 전달해야한다.
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doPost호출");
		doService(req,res);
	}
}

