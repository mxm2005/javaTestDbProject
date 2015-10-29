<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.db.helper.sqlserver.*"%>
<%
	db d = new db();
	String str = d.getCityListStr();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'testListBind.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.content table{border:solid 1px #666666;border-collapse:collapse;}
.content table th,td{border:solid 1px #999999;}
</style>
</head>

<body>
	This is my JSP page.
	<br>
	<%=str %>
	<div class="content" data-bind='simpleGrid: gridViewModel'></div>
</body>
</html>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/knockout-3.0.0-min.js"></script>
<script type="text/javascript" src="js/knockout.simpleGrid.3.0.js"></script>
<script type="text/javascript">
	var lst =JSON.parse('<%=str%>');
	//alert(lst[1].cityName);
	this.gridViewModel = new ko.simpleGrid.viewModel({
		data : lst,
		columns : [ {
			headerText : "编号",
			rowText : "ID"
		}, {
			headerText : "地市",
			rowText : "cityName"
		}, {
			headerText : "编码",
			rowText : "cityNo"
		} ],
		pageSize : 10
	});
	$(document).ready(function() {

		ko.applyBindings(gridViewModel);

	});
</script>
