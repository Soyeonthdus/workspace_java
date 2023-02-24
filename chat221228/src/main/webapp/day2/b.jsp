<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.Map" %>
<%
//테스트 시나리오
//서블릿을 경유하여 forward메소드 호출의 결과 페이지로 b.jsp가 출력될 때
//rmap이 null이 아님
//그러나 b.jsp페이지를 직접 호출하면 출력값은 null이 될 것이다
	Map<String, Object> rmap = (Map<String, Object>)request.getAttribute("rmap");
	out.print(rmap.get("mem_id"));
%>
<hr>
<!-- 익스프레션으로 출력하기 -->
<% rmap.get("mem_id"); %>