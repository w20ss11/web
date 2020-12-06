<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>demo10_1 动态包含</h3>
	<jsp:include page="demo10_2.jsp"></jsp:include>
	<p>这种包含不可以这样《%=变量名 %》引用demo10_2中变量，因为生成了两个servlet java文件</p>
	<%-- <jsp:forward page = "hello.jsp"></jsp:forward> --%>
	相当于<%-- request.getRequestDispatcher("hello.jsp").forward(request,response); --%>
	
	
	<!-- jsp:forward 可以用jsp:param子标签传入参数 -->
	<%-- <jsp:forward page = "demo10_3.jsp">
		<jsp:param value="uservalue" name="username"></jsp:param>
	</jsp:forward>  --%>
</body>
</html>