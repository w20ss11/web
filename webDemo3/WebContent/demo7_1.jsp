<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demo7_1</title>
</head>
<body>
	<h3>demo7_1</h3>
	<h4>转发和重定向</h4>
	<%
		//1. 请求转发
		request.getRequestDispatcher("demo7_2.jsp").forward(request, response);
	%>
	
	<%
		//2. 请求重定向
		//response.sendRedirect("demo7_2.jsp");
	%>
</body>
</html>