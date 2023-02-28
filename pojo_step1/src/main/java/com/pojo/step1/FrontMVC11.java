package com.pojo.step1;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

//나는 HttpServlet을 상속받았으므로 서블릿이다
//그래서 나는 메소드 파라미터로 request와 response를 받을 수 있다
public class FrontMVC11 extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC11.class);
	private static final long serialVersionUID = 1L;
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출");
		// -> /board/getBoardList.st1 -> web.xml ->  url-pattern ->  *.st1
		String uri = req.getRequestURI();//주소창에 입력된 값중 도메인과 포트번호가 제외된 값만 담음
		logger.info(uri);// /board/getBoardList.st1
		//server.xml <Context path="/"
		String context = req.getContextPath();//"/" -> server.xml
		logger.info(context);// /dept/getDeptList.st1
		String command = uri.substring(context.length()+1);//context정보만 제외된 나머지 경로정보담음
		System.out.println(command);//dept/getDeptList.st1
		int end = command.lastIndexOf(".");//16 -st1잘라내기위해 사용
		System.out.println(end);//16출력
		command = command.substring(0,end);//===>board/getBoardList
		System.out.println(command);
		String upmu[] = null;//upmu[0] = board|폴더명, upmu[1] = getBoardList st1제거된 상태임
		upmu = command.split("/");//dept , getDeptList
		ActionForward1 af = null;
		Board1Controller boardController = null;
		//Board1Controller는 서블릿이 아니므로 요청객체와 응답객체를 주입받지 못함
		//execute호출시 파라미터 전달하기 - 구조
		//원본이 넘어가는 거니까 거기에 upmu배열을 저장한다
		req.setAttribute("upmu", upmu);
		if("board".equals(upmu[0])) {
			
			//여기에 진입하기 위한 테스트 url작성하시오. -> http://localhost:9000/board/getBoardList.st1
			boardController = new Board1Controller();//나는 서블릿 아니다.
			//서블릿이 아니지만 req와 res는 반드시 필요하다 - 웹서비스를 제공
			//톰캣서버를 경유했을 때 요청객체와 응답객체를 활용가능함
			//FrontMVC11경유해라
			af = boardController.execute(req,res);
		}
		
		if(af!=null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
			}else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req,res);
			}
		}//end for page이동처리에 대한 공통 코드부분
	}
	
	/************************************************************************************
	 * Restful API - GET방식
	 * 브라우저에 인터셉트 당한다 - 포장이 안됨, 노출되었다, 그래서 브라우저가 아는척 한다
	 * 헤더에 값이 담기므로 제약이 있다
	 * 첨부파일 처리에 사용불가함
	 * 링크걸수 있다
	 * 단위테스트 가능함(Mockup)
	 ************************************************************************************/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//오버라이딩 하는 doGet 또는 doPost 메소드가 아닌것은 톰캣서버로 부터 req와 res 를 주입받을 수
		//없다.
		//그래서 doGet, doPost메소드 내에서 doService메소드를 호출할 때 파라미터로 req와 res를 넘긴다
		//그래야 사용자 정의 메소드에서도 요청객체와 응답객체를 사용할 수  있으니까
		//POJO프레임워크는 요청객체와 응답객체에 의존적이다 라고 말할 수 있다.
		//스프링 프레임워크에서는 요청객체와 응답객체 없이도 모든 서비스가 가능하게 되었다.
		//없이도 가능하다는 것은 메소드의 파라미터로 주입받는다 라는 걸 의미함
		//스프링에서는 메소드의 파라미터가 줄었다 늘었다 할 수 있다.- 메소드 오버로딩
		doService(req,res);
	}
	/************************************************************************************
	 *  Restful API - POST방식
	 *  링크를 걸 수 없다
	 *  단독으로 호출 테스트 불가함 - postman(GET,POST,PUT,DELETE)이 필요하다
	 *  브라우저에 쿼리스트링에 노출이 안됨 - 포장되어 있는 선물
	 *  :노출이 안되어서 브라우저에 인터셉트 당하지 않음 - 모든 요청이 무조건 서버로 전달됨
	 *  패킷에 바디부분에 값이 담김 - 용량 제한이 없다 - 첨부파일
	 *
	 ************************************************************************************/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//post방식으로 요청이 일어나면 서블릿의 doPost가 받는다
		//이 때 톰캣컨테이너로 부터 요청객체와 응답객체를 주입받는다(의존성 주입)
		//개발자가 정의한doService 호출시 파라미터로 주입받은 요청객체와 응답객체를 넘긴다
		doService(req,res);//pass by value
	}
}