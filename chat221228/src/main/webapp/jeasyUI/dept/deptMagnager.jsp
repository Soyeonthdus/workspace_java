<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 관리</title>
<%@ include file ="../../common/easyUI_common.jsp" %>
</head>
<body>
<table id="dg">
	<script>
	$(document).ready(function(){ //ready가 기다리는 애
	$('#dg').datagrid({
		title : "부서관리",
	    url:'datagrid_data.json',
	    columns:[[
	        {field:'code',title:'Code',width:100},
	        {field:'name',title:'Name',width:100},
	        {field:'price',title:'Price',width:100,align:'right'}
	    ]]
	});
	})
	</script>
</table>
</body>
</html>