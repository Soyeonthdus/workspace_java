package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//Model, ModelMap
public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	//전역변수
	//표준요청객체
	HttpServletRequest req = null;
	//cos.jar에서 제공하는 요청 객체 - 첨부파일로 post이면서 encType속성이 적용된 경우 사용할 것
	MultipartRequest multi = null;
	//첨부파일의 업로드 물리적인 경로
	String realFolder = null;
	//첨부파일 한글 처리
	String encType = "UTF-8";
	//첨부 파일 최대 크기
	int maxSize = 5*1024*1024;
	
	//생성자
	public HashMapBinder() {}
	//생성자 파라미터(지역변수)에 요청객체가 필요한 이유는 뭐죠?
	public HashMapBinder(HttpServletRequest req) {
		//생성자의 1역할 - 전변의 초기화
		this.req = req;
		realFolder = "D:\\workspace_java\\chat221228\\src\\main\\webapp\\pds";
	}
	
	public void multiBind(Map<String, Object> pMap) {
		logger.info("multiBind 호출");
		//컨트롤계층에서 생성한 맵 객체 비우기
		pMap.clear();
		try {
			multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		}catch(Exception e){
			logger.info(e.toString()); //발생한 예외 이름 출력하기
		}
		//에뉴머레이션은 리스트나 맵안에 뭐가 있는지를 체크해준다. getParameterNames는 Http가 제공. 
		//여러개라서 에뉴머레이션으로 받음 그렇게 정해짐...
		Enumeration<String> en = multi.getParameterNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			pMap.put(key, multi.getParameter(key));
		}
		//첨부파일에 대한 정보 받아오기
		Enumeration<String> files = multi.getFileNames(); //n개 만큼 
		if(files != null) {
			//업로드 대상 파일을 객체로 만듦
			File file = null; //내용까지 복제되는건 아니다 - 파일명에 대해서만 객체화해줌
			while(files.hasMoreElements()) {
				String fname = files.nextElement();
				String filename = multi.getFilesystemName(fname);
				pMap.put("bs_file", filename);
				if(filename != null && filename.length()>1) {
					file = new File(realFolder+"\\"+filename);
				}
				logger.info(file);
			}//end of while
			//첨부파일의 크기 담는 변수
			double size = 0;
			if(files !=null) {
				size = file.length(); //파일크기를 byte 단위로 담아줌
				size = size/1024.0; // byte -> kbyte
				pMap.put("bs_size", size);
			}
		}//end of if
		
	}//end of 메소드
	
	//메소드
	//어떤 페이지 어떤 상황에서 공통코드 재사용 가능하게 할 것인가?
	//업무별 요청 클래스에서 주입 받을 객체를 정해서 메소드의 파라미터로 전달 받음
	//전달 받은 주소번지 원본에 값을 담아 준다
	public void bind(Map<String, Object> pMap) {
		pMap.clear();
		//Enumeration은 인터페이스 인데 List,Map안에 뭔가 들어있는지 체크해줌
		//있으면 꺼내는 메소드까지 제공해줌 -> 
		Enumeration<String> en = req.getParameterNames(); //
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			pMap.put(key,  req.getParameter(key));
		}
	}
}
