<%@page import="java.text.Format"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.db.helper.sqlserver.*"%>
<%
	db d = new db();
	String ss = d.getTestStr();
%>

<html>
<body>
	<%
		out.println("hello..."+ss);
	%>
	<br>
	<%=ss %>
</body>
</html>