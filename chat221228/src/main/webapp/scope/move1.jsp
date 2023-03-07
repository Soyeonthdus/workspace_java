<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import = "com.book.scope.Sonata" %><!-- import를 통해 페이지 찾아옴 -->
<%
	Sonata myCar = (Sonata)request.getAttribute("myCar");
	String oMyCar = request.getParameter("oMyCar");
	Sonata herCar = (Sonata)request.getAttribute("herCar");
	String oHerCar = request.getParameter("oHerCar");
	Sonata yourCar = (Sonata)session.getAttribute("yourCar");
	String oYourCar = request.getParameter("oYourCar");
	out.print("scope1.jsp에서 생성된 객체가 유지되나요?");
	out.print("<hr>");
	out.print(myCar.carName+","+oMyCar.concat("1")+"자동차".concat("1"));
	out.print("<hr>");
	out.print(herCar.carName+","+oHerCar.indexOf(3)+"소나타".concat("1"));
	out.print("<hr>");
	out.print(yourCar.carName+","+oYourCar.charAt(2)+new Boolean(true).toString());
%>