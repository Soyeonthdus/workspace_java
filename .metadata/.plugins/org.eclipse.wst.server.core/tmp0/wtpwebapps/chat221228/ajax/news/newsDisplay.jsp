<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script>
  	const autoReload = () => {
  		console.log("autoReload 호출")
  		//ajax함수는 jquery.min.js가 제공하는 api이다
  		//ajax함수는 결국 XMLHttpRequest대신함
  		//const ajax = new XMLHttpRequest();
  		//ajax.open("GET", url, false)
  		//ajax.send()
  		 $.ajax({
  	          type: "GET", 
  	          url: "newsList.jsp", //요청하고 있는 url페이지
  	          success: function (data) { //성공했을 때 
  	            //파라미터 data에는 boardSellAction.html처리된 결과를 담음 = .responseText
  	            //console.log(data);
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
  //body 속에 있으므로 호출하지 않아도 자동실행
  //jquery(document)
  //window <- document <- ready(function(){실행문 : 변수선언, if문, switch문, i+j}) : 함수
  //{} : 객체 or 함수의 구현부
  	$(document).ready(()=>{
  		//실행문이 오는 자리
  		start = () =>{
  			setInterval(autoReload, 2000); //autoReload는 함수이다. 일급함수 //2초지연발생
  		}
  		//function start(){}
  		start(); //호출 
  	})//end of ready - DOM을 다 읽었으면
  </script>
  <div id = "d_news">뉴스 준비중...</div>

</body>
</html>

<!-- 
	html(단방향, 변수선언이나 제어문 지원 안됨, 이벤트 처리 불가)은 순차적으로 실행
	자바스크립트 코드의 위치에 따라서 document.querySelector(id or class or else)
	: 선언이 먼저
	자바스크립트 위치
	1) head 안에 - 전변선언, 함수선언 할 때(호출을 해야 실행이 됨)
		만일 자바스크립트의 처리를 지연시키고 싶을 때는 defer를 사용하여 DOM Tree가 다 그려질때까지 기다림
	2) body 안에 - 호출하지 않아도 실행됨 - 단 함수로 선언된 부분 제외
		body가 화면에 보이는 부분임. 화면의 역할은 듣기이다. 사용자가 입력한 것을 듣는 역할
		ID와 비번을 적고 누른다 -> Request
		
	자바스크립트로 화면을 그릴 수 있다 -> document.write("<font color = 'red' size = 18></font>")
	write는 브라우저에 쓸 수 있게 해주는 명령어
	
	Java는 브라우저에 쓸 수 없다 -> System.out.prinln(<b>굵은 글씨</b>) 안됨
	
	그러나 서블릿은 브라우저에 쓸 수 있다 : out.print();  
	
	out.print("<font color = 'red' size =18>안녕</font>"); //서버에서 처리해준다. HTML이다
 -->
