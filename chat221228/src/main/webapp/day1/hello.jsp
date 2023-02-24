<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id ="f_test" method ="post" action = "/day1/hello.kh">
<!-- 전송버튼에 대한 이벤트 처리가 없는데 요청이 서버에 전달되는 이유는 뭘까요? 버튼의 기본타입이 submit이라서  -->
	<input type = "button" id ="btnsend" value="전송">
	<script type ="text/javascript">
		const btnSend = document.querySelector("#btnsend");
		btnSend.addEventListener('click', ()=>{
			alert("전송 버튼 클릭")
			document.querySelector("#f_test").submit()
		})
	</script>
</form>
</body>
</html>