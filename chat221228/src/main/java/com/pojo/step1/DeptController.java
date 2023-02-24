package com.pojo.step1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//SELECT deptno, dname, loc FROM dept
public class DeptController implements Action {
	Logger logger = Logger.getLogger(DeptController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ActionForward af = new ActionForward();
		//FrontMVC1클래스에서 request객체에 저장된 배열을 꺼내기 -> 20번
		String upmu[] = (String[])req.getAttribute("upmu");
		DeptLogic deptLogic = new DeptLogic();
		String path = null;
		boolean isRedirect = false;
		//너 부서목록 조회할거니?
		if("getDeptList".equals(upmu[1])) {
			List<Map<String,Object>> deptList = deptLogic.getDeptList();
			req.setAttribute("deptList", deptList);
			//응답페이지 이름 path를 통해 결정
			path = "getDeptList.jsp"; //jsp의 이름
			//redirect로 할지 forward로 할지를 결정한다
			isRedirect = false;//false이면 forward이다 - 요청이 유지된다. - 주소창은 그대로인데 페이지는 바뀜
		}
		else if("jsonDeptList".equals(upmu[1])) { //리액트를 위해
			String jsonDoc = deptLogic.jsonDeptList();
			req.setAttribute("jsonDoc", jsonDoc);
			path = "jsonDeptList.jsp";
			isRedirect = false;//false이면 forward이다 - 요청이 유지된다. - 주소창은 그대로인데 페이지는 바뀜
		}
		//너 부서등록하려구?
		else if("deptInsert".equals(upmu[1])) {
			//insert into dept(deptno,dname,loc) values(?,?,?)
			int result = deptLogic.deptInsert(); 
		}
		//너 부서정보  수정해야돼?
		else if("deptUpdate".equals(upmu[1])) {
			int result = deptLogic.deptUpdate(); 
			
		}		
		//너희 부서 없어졌다
		else if("deptDelete".equals(upmu[1])) {
			int result = deptLogic.deptDelete(); 
			
		}		
		af.setPath(path);
		af.setRedirect(isRedirect);
		return af;
	}
	public ActionForward getDeptList() {
		//res.sendRedirect();
		return null;
	}
}
