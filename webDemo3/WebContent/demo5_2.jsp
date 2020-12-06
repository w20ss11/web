<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h2>attr 2 page:<%= new Date() %></h2>
 	<br><br>
 	pageContextAttr:<%= pageContext.getAttribute("pageContextAttr") %>
 	
 	<br><br>
 	requestAttr:<%= request.getAttribute("requestAttr") %>
 	
 	<br><br>
 	sessionAttr:<%= session.getAttribute("sessionAttr") %>
 	
 	<br><br>
 	applicationAttr:<%= application.getAttribute("applicationAttr") %>
 	<br><br>
 	<a href="demo5_1.jsp">to demo5_1.jsp</a>
 	<br><br><br><br><br>
 	<p>pageContext 的作用范围仅限于当前JSP页面</p>
 	<p>request的作用范围仅限于同一个请求</p>
 	<p>session的作用限于一次对话（浏览器打开直到关闭，此期间会话不失效）</p>
 	<p>application作用域当前web应用，范围最大，属性在其他各处jsp或servlet都可以获取</p>
</body>
</html>