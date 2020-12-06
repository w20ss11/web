<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>servletContextListenser</h3>
	监听ServletContext的类,当前web应用加载时，web应用的初始化操作<br>
	如创建数据库连接池，spring的ioc容器，读取当前web应用的初始化参数<br>
	<br>
	context-param<br>
	servletcontext reuest session 有listener<br>
	<br>
	pagecontext没有监听<br>
	
	session destroy：1.session.invalidate 2.session过期  3.web应用被卸载<br>
	
	<a href="demo1_2.jsp">to demo1.jsp</a>
	<% request.setAttribute("request", "requestvalue"); %>
	<%--<jsp:forward page="demo1_2.jsp"></jsp:forward>--%>
	<br><hr><br>
	
	<a href="Demo1_Servlet">Demo1_Servlet</a>
	
	<h3></h3>
</body>
</html>