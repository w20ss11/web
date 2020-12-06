<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	forward<br>
	demo3_1.jsp → demo3_2dispatcher.jsp → demo3_3.jsp <br>
	这里是转发，所以test对应的filter没有起作用<br>
	直接发get或post，请求：REQUEST<br>
	<a href="demo3_2dispatcher.jsp">to demo3_2</a>
</body>
</html>