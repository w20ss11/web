<%@page import="java.util.Date"%>
<%@page import="cn.wss.listener.Demo4_Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
		Customer customer = new Customer();
		session.setAttribute("customer", customer);
	
		System.out.println("------------------------");
		
		session.removeAttribute("customer");
	--%>
	<h3>demo4 session bind</h3>
	<% 
	Demo4_Customer customer = (Demo4_Customer)session.getAttribute("customer");
	
		if(customer == null){
			customer = new Demo4_Customer();
			customer.setTime("" + new Date()); 
			session.setAttribute("customer", customer);
			System.out.println("jsp:创建一个新的 Customer 对象: " + customer + ", 并放入到 session 中");
		}else{
			System.out.println("jsp:从 session 中读取到 Customer 对象: " + customer);
			
		}
	%>
	<br><hr><br>
	
	<h3>SessionActivationListener</h3>
	> 活化: 从磁盘中读取 session 对象<br>
	> 钝化: 向磁盘中写入 session 对象<br>
	> session 对象存储在tomcat 服务器的 work\Catalina\localhost\contextPath 目录下. SESSION.SER<br>
	<br>
</body>
</html>