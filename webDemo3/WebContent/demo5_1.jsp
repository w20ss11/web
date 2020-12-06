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
<!-- 
	Object getAttribut(String name):获取指定的属性
	Enumeration getAttributeNames():获取所有的属性的名字组成的Enumeration对象
	removeAttribute(String name):移除指定的属性
	void setAttribute(String name,Object o):设置属性
	
	域对象：pageContext request session application对象都有这些方法
 -->
 	<%
 		pageContext.setAttribute("pageContextAttr", "pageContextValue");
 		request.setAttribute("requestAttr", "pageContextValue");
 		session.setAttribute("sessionAttr", "pageContextValue");
 		application.setAttribute("applicationAttr", "pageContextValue");
 	%>
 	<h2>attr 1 page:<%= new Date() %></h2>
 	<br><br>
 	pageContextAttr:<%= pageContext.getAttribute("pageContextAttr") %>
 	
 	<br><br>
 	requestAttr:<%= request.getAttribute("requestAttr") %>
 	
 	<br><br>
 	sessionAttr:<%= session.getAttribute("sessionAttr") %>
 	
 	<br><br>
 	applicationAttr:<%= application.getAttribute("applicationAttr") %>
 	
 	 <a href="demo5_2.jsp">to demo5_2.jsp</a>
</body>
</html>