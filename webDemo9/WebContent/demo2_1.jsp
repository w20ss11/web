<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>session page</h3>
	session: 当第一次访问 WEB 应用的一个 JSP 或 Servlet 时, 且该 JSP 或 Servlet 中还需要创建 session 对象. 此时服务器会
	创建一个 session 对象. <br>
	<%
		HttpSession session1 = request.getSession(true);
		//session.setMaxInactiveInterval(10);
	
		//session.invalidate();
	%>
	浏览器关闭session不一定destroy，因为session.ser持久化<br>
	带着jsession id，可以不创建新的session，找回上次的session<br>
	
	application: 贯穿于当前的 WEB 应用的生命周期. 当前 WEB 应用被加载时创建 application 对象, 当前 WEB 应用被卸载时
	销毁 application 对象.<br>
</body>
</html>