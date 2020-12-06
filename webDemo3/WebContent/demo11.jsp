<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>demo11 中文乱码问题</h3>
	<p>1.在JSP上输入中文，请求页面后不出现乱码：</p>
	<p>保证contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" charset和enconding一致，
	且都支持中文，通常建议utf-8,还需要保证浏览器显示的字符编码也和请求的一致</p>
	
	<br>
	
	<p>2.获取中文参数值 post请求</p>
	<p></p>
	<form action="demo11.jsp" method="post">
		username:<input type="text" name="username" />
		<input type="submit" value="submit" />
	</form>
	<br>
	<p>request默认采用编码iso-8859-1，换为utf-8</p>
	<% request.setCharacterEncoding("utf-8"); %>
	username:<%= request.getParameter("username")  %>
	
	<br>
	
	<p>3.get请求的中文</p>
	<p>tomcat下config serve.xml中，将《Connector port="80" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />改为《Connector port="80" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" useBodyEncodingForURI="true"/></p>
</body>
</html>