<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/demo8_2.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP指令——page</h3>
	<p>《%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%》JSP指令只是告诉引擎如何处理JSP页面的其余部分</p>
    <br>
    <p>Page指令：</p>
    <p>用于定义JSP页面的各种属性，最好卸载JSP的起始位置</p>
    <p>
    	1.导入哪些包 如《%@page import="java.util.Date"%》
    	《%@ page session="false" %》不再使用session对象
    </p>
    <%
    	int i = 10/0;
    %>
</body>
</html>