<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    	확장자는 jsp이지만 마임타입은 html이다 => 브라우저는 이 파일을 html문서로 생각한다는 의미
    	왜냐하면 page다이렉티브에 contentType에 설정된 마임타입때문이다
    	
    	실행을 하면(URL주소에 해당 페이지를 요청하면) 
    	-> c.jsp
    	-> (jsp-api.jar : jsp엔진, jsp컨테이너, 톰캣에 있음)를 통해 c_jsp.java로 변경됨 
    	-> (servlet-api.jar : 서블릿엔진)을 통해 c_jsp.class로 변경됨 
    	
    	out.print() out은 jsp가 제공하는 내장객체 - dos창이 아닌 브라우저에 쓴다
    	: 자바스크립트와 같은 원리로 자바인데 브라우저에서 동작이 가능함
     -->
<script>
document.write("<b>굵은글씨</b>")
</script>