<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서관리2</title>
<%@ include file="../../common/easyUI_common.jsp" %>
<script type="text/javascript">
const insertForm=()=>{
	console.log('입력화면열기');
	$('#dg_dept').dialog({
	    title: '정보를 입력하세요.',
	    width: 500,
	    height: 500,
	    closed: false,
	    cache: false,
	    href: 'insertForm.jsp',
	    modal: true
	});
	
	
}</script>

</head>
<body>
<table id="dg" toolbar="#toolbar"></table>

 <div id="toolbar">
      <a
        href="javascript:void(0)"
        class="easyui-linkbutton"
        iconCls="icon-add"
        plain="true"
        onclick="insertForm()"
        >입력</a
      >
    </div>
    <div id="dg_dept">부서정보등록.</div>

<script type="text/javascript">

	$('#dg').datagrid({
		title:'부서관리',
	    url:'../dept.json',
	    columns:[[
	        {field:'deptno',title:'부서번호',width:100},
	        {field:'dname',title:'부서명',width:100},
	        {field:'loc',title:'지역',width:100,align:'right'}
	    ]]
	 
	});//부서관리테이블
	
</script>


</body>
</html>