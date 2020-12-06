<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="cn.wss.mvc.Demo2_Person" scope="session"></jsp:useBean>
	
	
	<!-- 阅读顺序四、person属性值来自于请求参数(?age=100&id=1&name=wss) -->
	<jsp:setProperty property="*" name="person"/>
	<!--  若 property 的值为 *, 省略 value 属性值, 则将自动为所有属性赋值为对应的请求参数的值. -->
	
	<!-- 阅读顺序五：设置值以及usebean -->
	<jsp:setProperty property="name" value="wss" name="person"/>
	
	
	<!-- 阅读顺序三、person属性打印 -->
	age:<jsp:getProperty property="age" name="person"/>
	
	<%-- 阅读顺序二、person变量属性修改的两种方式
	<jsp:setProperty property="age" value="10" name="person"/>
	<%
		person.setAge(10);
	%>
	--%>
	
	<%-- 阅读顺序一、person变量
		//1. 从 scope(session) 中获取 id(customer) 属性值, 赋给 class(com.atguigu.javaweb.Customer) 
		//类型的 id(customer) 变量
		Customer customer = (Customer)session.getAttribute("customer");
		
		//2. 若属性值为 null, 则利用反射创建一个新的对象, 把该对象赋给 id(customer), 并以 id(customer) 
		//为属性名让如到 scope(session) 中.
		if(customer == null){
			customer = (Customer)Class.forName("com.atguigu.javaweb.Customer").newInstance();
			session.setAttribute("customer", customer);
		}
	--%>
</body>
</html>