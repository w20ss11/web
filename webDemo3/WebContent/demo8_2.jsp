<%@page import="org.apache.tomcat.util.descriptor.web.ErrorPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>error page</h4>
	<p>设置isErrorPage="true"</p>
	<p>可以在web.xml中配置错误页面</p>
	<p>
		<error-page>  
			 <error-code>404</error-code>  
			 <location>/WEB-INF/404.html</location>  
		</error-page> 
	</p>
	Error Message:
	<%-- <%= exception.getMessage() %> --%>
</body>
</html>