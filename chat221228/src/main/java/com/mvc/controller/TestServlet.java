package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc.dao.TestDao;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(TestServlet.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
		{
			logger.info("doService 호출");
			logger.fatal("doService 호출");
			logger.debug("doService 호출");
			logger.warn("doService 호출");
			logger.error("doService 호출");
			TestDao tDao = new TestDao();
			List<Map<String, Object>> mList = tDao.getBookMember();
			tDao.getBookMember();
			//페이지 이동
			//페이지 이름 getMemverList.jsp
			//페이지의 물리적인 경로는 어디를 바라보고 있는가? -> web.xml -> servlet-mapping[test/test.do] -> url-pattern
			//경로명 /요청을 처리하는 이름.do[뒤에 온 do확장자는 의미 없다 - 해당요청을 인터셉트해서 해당업무를 담당하는]
			//클래스에 연결(FrontController.java 설계 - 각 업무별 XXXController필요함)을 해야함
			//페이지 처리는 JSP에게 맡김
			//서블릿은 요청을 받아서 업무 담당자에게 연결(매핑, 매칭)하는 역할
			//이것을 어떻게 나눌것인가?
			//요청은 업무 담당자나 사용자 선택에 따라 결정됨
			//그 결정에 대응하는 클래스를 FrontController연결
			//FrontCotroller에서 실제 업무를 담당하는 xxx.Controller에 전달할 때
			//요청객체와 응답객체 전달되어야 한다
			//요청객체 무엇을 누릴수 있나?
			//사용자가 입력한 값을 듣기 위해 필요하다
			//getParameter("") : String
			//request.getParameter("XXX"); mem_id, mem_name, meme_address
			//HttpSession session = request.getSession();//세션 객체 생성
			//http 프로토콜이 비상태 프로토콜 이므로 상태값을 관리하는 별도의  메커니즘 필요
			//쿠키(최근에 본 상품)와 세션(시간 연장)(시간을 지배한다) <- List, Map <- 객체배열 <- 배열 - 원시형 타입(변수)
			//response
			//res[pmse/setCpmtetmType(); 마임타입을 결정한다
			//서블릿인데 json, 서블릿인데 html, 서블릿인데 xml
			//response.setContentType("application/json")
			//response.setContentType("text/html")
			//response.setContentType("text/xml")
			//response.setContentType("text/css")
			//response.send(Redirect("페이지이름") -> 페이지 이동
			//주소창이 바뀐다 -> 기존에 요청이 끊어지고 새로운 요청이 발생함
			//그런데 마치 계속 유지하고 있는 것처럼 보여져야 함 -> 그러니까 쿠기나 세션에 담아둔다 -> 왜냐면 비상태 프로토콜
			//쿠키 - String문자열 - 객체는 못받음 -> 로컬PC에만 있음 -> 노출 가능성 있음 -> 보안에 취약함
			//세션 - 캐시메모리 - 객체 - very good -> 서버는 캐시메모리 -> 노출 가능성 없음
			//request는 세션을 만들 때 사용한다 ->  
			//response : doGet, doPost -> 톰캣이 주입해준다 -> 요청이 일어났을 때 -> 마임타입을 결정할 수 있다
								//setContentType -> sendRedirect : 페이지이동
			//아래코드를 만나기 전까지는 http://localhost:9000/test/test.do
			//를 보여주다가 아래 문자를 만나면 그 때 http://localhost:9000/test/getMemberList.jsp를 요청함
			//테스트 시나리오
			//방법1 : TestServlet.java 소스에서 오른쪽 버튼 눌러 실행시킨다
			//방법2 : 브라우저 주소창에 http://localhost:9000/test/test.do라고 요청한다
			res.sendRedirect("/test/getMemberList.jsp");
			//String cTime = tDao.testDate();
			//logger.info("today : " + cTime);
		}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
		{
			doService(req, res);
		}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
		{
			doService(req, res);
		}


}
