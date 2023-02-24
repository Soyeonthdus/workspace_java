<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서등록-다이얼로그</title>
<%@ include file="../../common/easyUI_common.jsp" %>

</head>
<body>

<div style="margin:20px 0;"></div>
<div style="margin:30px">
        <form id="f_dept" method="get">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="deptno" label="부서번호:" labelPosition="top" data-options="prompt:'Enter 부서번호...'" style="width:200px;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="dname" label="부서명:" labelPosition="top" data-options="prompt:'Enter 부서명...'" style="width:300px;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="loc" label="지역:" labelPosition="top" data-options="prompt:'Enter 지역...'" style="width:300px;">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="너의 매력포인트:" labelPosition="top" data-options="prompt:'Enter 매력...'" style="width:300px;">
        </div>
        
        <div style="text-align:center">
            <a href="javascript:insertAction()" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">등록</a>
        </div>
        </form>
</div>
<script type="text/javascript">
	const insertAction =()=>{
//		console.log("입력 호출 성공")
		console.log($("#_easyui_textbox_input1").val()+","+$("#_easyui_textbox_input2").val()+","+$("#_easyui_textbox_input3").val())
		const u_deptno=$("#_easyui_textbox_input1").val()
		const u_dname=$("#_easyui_textbox_input2").val()
		const u_loc=$("#_easyui_textbox_input3").val()
		$.ajax({
			method:"get",
			url:"/jEasyUI/dept/insertAction.do?deptno="+u_deptno+"&dname="+u_dname+"&loc="+u_loc,
			success:function(data){
				console.log("톰캣 서버에서 응답으로 보낸 값==>"+data)
			}
		})
		
	}
	/* 서블릿이 되기위한 조건은 반드시 http서블릿을 상속 받아야 한다. */
</script>

</body>
</html>