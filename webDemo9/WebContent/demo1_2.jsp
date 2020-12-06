<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>demo1</h3>
	
	<%--
		<% session.invalidate(); %> 
	--%>
	
	
	从demo1_1→servlet→demo1_2，在servlet中使用转发，只有一个request<br>
	在servlet中使用重定向，则从从demo1_1→servlet有一个request，从servlet→demo1_2为另一个request<br>
	
	
	<%=request.getAttribute("request") %>
</body>
</html>