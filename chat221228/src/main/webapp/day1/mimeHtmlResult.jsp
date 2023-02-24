<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MimeHtmlServlet2 응답페이지</title>
</head>
<body>
<h2>응답하라</h2>
<%
	//Service 지역변수
	// 스크립틀릿에 선언한 변수는 지역변수이다
	//왜냐면 a.jsp -> a_jsp.java 로 바뀔 때 service메소드 안으로 들어가기 때문이다
	String myName = null;  
	Integer age = null;
	
	// 서블릿에 있는 객체를 쓰고 싶어 = 세션을 사용해야한다
	//getAttribute의 리턴타입은 Object이다 <->  getparameter의 리턴타입은 String이다
	myName = (String)session.getAttribute("myName");	
	age = (Integer)session.getAttribute("age");	
	
	Map<String, Object> rmap = (Map<String,Object>)session.getAttribute("rmap");
	if(rmap !=null){ //NullPointerException 방어 코드
		Object keys[]=rmap.keySet().toArray();
		for(int i =0; i < keys.length; i++){
			out.print(rmap.get(keys[i]));
			out.print("<br/>");
		}
	}
	
	out.print("<hr>");
	
	List<Map<String,Object>> mList = (List<Map<String,Object>>)session.getAttribute("mList");
	if(mList !=null){
		for(int i =0; i <mList.size(); i++){ //mList.size()는 서랍의 개수(List(행,가로)안에 Map(열,세로)이 있으므로
			Map<String,Object> rMap = mList.get(i);
			out.print(rMap.get("mem_id")+","+rMap.get("mem_pw")+","+rMap.get("mem_name"));
			out.print("<br>");
		}
	}//end of if
	
		out.print("<hr>");
	out.print(myName); 
	out.print("<br/>");
	out.print(age);
	
	
%>
</body>
</html>