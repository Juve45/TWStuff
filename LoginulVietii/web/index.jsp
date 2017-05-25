<%@page import="app.fbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	fbConnection fbConnection = new fbConnection();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Facebook Login</title>
</head>
<body style="text-align: center; margin: 0 auto;">
	<div
		style="margin: 0 auto; ">
		<a href="<%=fbConnection.getfbAuthUrl()%>"> <img
			style="margin-top: 138px;" src="http://campaign.5000s.org/views/images/fb-login-button.png" />
		</a>
	</div>
</body>
</html>