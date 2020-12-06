<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>demo9_1:include指令 静态包含</h3>
	<p>当前JSP页面与静态引入的页面紧密结合为一个Servlet</p>
	<!-- 在demo9_1中包含demo9_2 -->
	<%@ include file="demo9_2.jsp" %>
	<p>这种包含直接《%=变量名 %》引用demo10_2中变量，因为生成了两个java文件</p>
	<%=name %>
</body>
</html>