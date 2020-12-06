<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.wss.mvc.Demo2_Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1.EL基本使用</h3>
	age:${sessionScope.person.age}<br>
	age:${sessionScope.person["age"]}<br>
	age:<% 
		Demo2_Person person = (Demo2_Person)session.getAttribute("person");
		out.print(person.getAge());
	%><br>
	<p>这里不用jsp的《jsp:getProperty，
	因为需要先《jsp:useBean id="person" class="cn.wss.mvc.Demo2_Person"</p>
	<hr>
	
	<h3>2.什么时候用[ ]</h3>
	<% 
		Demo2_Person person1 = new Demo2_Person();
		person1.setName("wss");	
	
		session.setAttribute("cn.wss.person", person1);
	%>
	name: ${sessionScope["cn.wss.person"].name}<br>
	<!-- 如果域对象中的属性名带有特殊字符, 则使用 [] 运算符会很方便. -->
	<p>EL主要通过.运算符，有时可以用[ ]</p>
	<hr>
	
	<h3>3.隐含对象，EL变量范围(从小到大开始找变量名)</h3>
	例如：${username}。它的意思是取出某一范围中名称为 username
	的变量。因为我们并没有指定哪一个范围的 username，所以它的默认值会先从 Page 范围找，假如
	找不到，再依序到 Request、Session、Application 范围。假如途中找到 username，就直接回传，
	不再继续找下去，但是假如全部的范围都没有找到时，就回传 null<br>
	<hr>
	
	<h3>4.自动的类型转换</h3>
	获取传过来的值<br>
	scope: ${param.score +11 }<br>
	scope: <%=request.getParameter("score") +11 %>
	<hr>
	
	<h3>5.隐含对象</h3>
	<h4>5.1 隐含对象之与范围相关的: pageScope, requestScope, sessionScope, applicationScope</h4>
	在demo3_1EL.jsp中定义了application域的time变量<br>
	time: ${applicationScope.time }<br>
	time: ${time }<br>
	time: <%= application.getAttribute("time") %><br>
	<br><br>
	
	<h4>5.2与输入有关的请求参数</h4>
	param：一个<br>
	paramValues：一组<br>
	score: ${param.score } $ {param.score }<br>
	score: <%= request.getParameter("score") %>  javascript<br>
	names: ${paramValues.name[0] } $ { paramValues.name[0] }<br>
	names: <%= 
		request.getParameterValues("name")[0]
	%>  javascript<br>
	
	<h4>5.3其他隐含对象: pageContext 等(cookie, header, initParam 只需了解.) </h4>
	pageContext: pageContext 即为 PageContext 类型, 但只能读取属性就可以一直的 . 下去。 <br>
	contextPath: ${pageContext.request.contextPath }<br>
	sessionId: ${pageContext.session.id }<br>
	sessionAttributeNames: ${pageContext.session.attributeNames }<br>
	initParam: ${initParam.initName }<br>
	
	Accept-Language: ${header["Accept-Language"] }<br>

	JSESSIONID: ${cookie.JSESSIONID.name } -- ${cookie.JSESSIONID.value }<br>
	
	<h4>5.4 运算符</h4>
	${param.score > 60 ? "及格" : "不及格" }
	<br>
	<% 
		List<String> names = new ArrayList<String>();
		names.add("abc");
		request.setAttribute("names", names);
	%>
	<!-- empty 可以作用于一个集合, 若该集合不存在或集合中没有元素, 其结果都为 true -->
	names is empty: ${empty requestScope.names }
	<br>
	
	
	<hr>
</body>
</html>