<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String datas = (String)request.getAttribute("jsonDoc");
	out.print(datas);
%>