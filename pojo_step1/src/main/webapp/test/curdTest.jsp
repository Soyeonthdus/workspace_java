<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menu = (String)request.getAttribute("menu");
	out.print("내가 선택한 메뉴는" + menu); 
	/*
	null이 출력된다 왜냐면 sendRedirect라서 
	= req가 원본이아니라 새로만들어진 요청객체라서
	서블릿에서 주입받능 request에 담겨있는 것이지 페이지 이동으로 출력된 화면이 가진
	request에는 menu담지 않았다.
	기존의 요청이 끊어지고 (url이 바뀌었잖아)새로운 
	URL이 그대론데 페이지가 바뀐다 = forward방식 = req와 res가 원본 그대로다
	*/
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crudTest</title>
</head>
<body>
crudTest페이지입니다.
<!-- 기존의 요청이 끊어지고 새로운 요청이 왔다.
http://localhost:9000/haha.st1요청했더니 (web.xml)st1찾아서->servlet-name->servlet->classname
get방식이니까 doGet메소드가(누가? 톰캣이 .st1기준-시스템호출-callback) 호출되고
서블릿이 호출될때 톰캣서버로부터 주입받은 request객체와 response객체가 아닌
새로운 request객체와 response객체라는 것이다. -->
</body>
</html>