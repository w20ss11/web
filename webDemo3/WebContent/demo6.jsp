<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="JSPServlet_demo6_1">前往JSPServlet_demo6_1</a>将转发到JSPServlet_demo6_3
	<br><br>
	<a href="JSPServlet_demo6_2">前往JSPServlet_demo6_2</a>将重定向到JSPServlet_demo6_3
	<br><br>
	<a href="JSPServlet_demo6_3">前往JSPServlet_demo6_3</a>
	<br><br>
	<h2>本质区别：</h2>
	<p>请求转发后，在转发到的最终的Servlet中，request对象是同一个,地址栏不变</p>
	<p>重定向后，在最终的Servlet中，request又生成了一个</p>
</body>
</html>