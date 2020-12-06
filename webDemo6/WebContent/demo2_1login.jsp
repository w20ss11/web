<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	demo2_1login.jsp经过usernameFilter PasswordFilter 到 demo2_2hello.jsp<br>
	分别检查username 和 password 是否等于 Tom 和 123456<br>
	在namefilter和passwordfilter配置tom和123456为当前web应用初始化参数<br>
	
	<font color="red">${message }</font>
	<br><br>
	
	<form action="demo2_2hello.jsp" method="post">
	
		username: <input type="text" name="username" value="${param.username }"/>
		password: <input type="password" name="password"/>
	
		<input type="submit" value="提交"/>
		
	</form>
</body>
</html>