<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	String menu = request.getParameter("menu"); // info or login or board or google
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<title>패턴1</title>
<style>
a {
	text-decoration: none;
}
</style>
<script defer type = "text/javascript">
	const autoReload = () => {
  		console.log("autoReload 호출")
  		 $.ajax({
  	          type: "GET", 
  	          url: "newsList.jsp", //요청하고 있는 url페이지
  	          success: function (data) { //성공했을 때 
  	            $("#d_news").html(data);
  	          },
  	          error:function(request, status, error){
  	        	  console.log("error")
  	        	  console.log("error" + request.status)
  	        	  console.log("error" + request.responseText) //에러메시지 가져오는 명령어
  	          }
  	        });
  	}
</script>
</head>
<body>
 <script type = "text/javascript">
  	$(document).ready(()=>{
  		//실행문이 오는 자리
  		start = () =>{
  			setInterval(autoReload, 2000); //autoReload는 함수이다. 일급함수 //2초지연발생
  		}
  		//function start(){}
  		start(); //호출 
  	})//end of ready - DOM을 다 읽었으면
  </script>
  
	<!-- 태그는 중첩해서 사용 가능함 -->
	<!-- 크기는 %로 주는 것이 좋다 가변적이니까 -->
	<table border="1" align="center" width="1000px">
		<tr>
			<td width="100%" height="50px">
				<!--====================top 시작====================-->
				<%@ include file="top.jsp"%><!-- include : jsp에서 제공하는,, 페이지 변환?작업을 할 수 있는 예약어같은가 -->
				<!--====================top 끝====================-->
			</td>
		</tr>
		<tr>
			<td>
				<!--====================body 시작====================-->
				<table>
					<tr>
						<!--====================메뉴 시작====================-->
						<td width="200px" height="400px">
							<%@ include file="menu.jsp"%>
						</td>
						<!--====================메뉴 끝====================-->
						<!--====================메인 시작====================-->
						<td width="800px" height="400px">
<%//스크립틀릿
							if(menu == null){			
%>
								<%@ include file="main.jsp"%>
<%
							} else if("info".equals(menu)) { // 앞이 상수 뒤에 들어오는게 변수여야 nullPointerException 방어 가능
%>
								<%@ include file="info.jsp"%>
<%
							} else if("login".equals(menu)) {
%>								
								<%@ include file="login.jsp"%>
<%
							} else if("board".equals(menu)) {
%>
								<%@ include file="board.jsp"%>
<%
							} else if("google".equals(menu)) {
%>
								<%@ include file="google.jsp"%>
<%
							}
%>
						</td>
						<!--====================메인 끝====================-->
					</tr>
				</table> <!--====================body 끝====================-->
			</td>
		</tr>
		<tr>
			<td width="1000px" height="30px">
				<!--====================bottom 시작====================-->
				<%@ include file="bottom.jsp"%>
				<!--====================bottom 끝====================-->
			</td>
		</tr>
	</table>
</body>
</html>
