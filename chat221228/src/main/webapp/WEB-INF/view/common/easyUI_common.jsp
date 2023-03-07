<%
	StringBuilder path = new StringBuilder(request.getContextPath()); //서버의 물리적인 경로 갖고옴
	path.append("/");
%>

<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>demo/demo.css" />
<script type="text/javascript" src="<%=path.toString() %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path.toString() %>js/jquery.easyui.min.js"></script>