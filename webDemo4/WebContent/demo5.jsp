<%@page import="java.util.ArrayList"%>
<%@page import="cn.wss.mvc.Demo2_Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="wss" uri="http://wss.com/tag/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>?name=abc&age=25&name1=abc&name2=def</h2>
	<h3>1.带标签体的自定义标签</h3>
	1.1.《wss:jspFragment》<br>
	<wss:jspFragment>hello Word</wss:jspFragment><br><br>
	
	1.2.《wss:printUpper》<br>
	<wss:printUpper time="3">我是天选之人 i'm the chosen one!</wss:printUpper><br><br>
	
	<%
		//模拟Servlet中的操作
		List<Demo2_Person> persons = new ArrayList<Demo2_Person>();
		persons.add(new Demo2_Person(1,"aa",12));
		persons.add(new Demo2_Person(2,"bb",13));
		persons.add(new Demo2_Person(3,"cc",14));
		persons.add(new Demo2_Person(4,"dd",15));
		persons.add(new Demo2_Person(5,"ee",16));
		request.setAttribute("persons", persons);
	%>
	1.3.《wss:forEach》<br>
	<c:forEach items="${requestScope.persons }" var="p">
	${p.id } -- ${p.name } <br></c:forEach>
	foreach:两个属性: items(集合类型, Collection), var(String 类型)<br>
	<wss:forEach items="${requestScope.persons }" var="p">
	${p.id } -- ${p.name } <br></wss:forEach>
	<hr>
	
	<h3>2.带父标签</h3>
	<!-- 父标签打印name到控制台.  -->
	<wss:parentTag>
		<!-- 子标签以父标签的标签体存在,  子标签把父标签的name属性打印到 JSP 页面上.  -->
		<wss:sonTag/>
	</wss:parentTag>
	<hr>
	
	<h3>3.c:choose</h3>
	?age=20<br>
	<c:choose>
		<c:when test="${param.age > 24}">^大学毕业</c:when>
		<c:when test="${param.age > 20}">^高中毕业</c:when>
		<c:otherwise>^高中以下...</c:otherwise>
	</c:choose><br>
	<wss:choose>
		<wss:when test="${param.age > 24}">^大学毕业</wss:when>
		<wss:when test="${param.age > 20}">^高中毕业</wss:when>
		<wss:otherwise>^高中以下...</wss:otherwise>
	</wss:choose><br>
	<p>* 若 when 的 test 为 true, 且 when 的父标签的 flag 也为 true, 则执行 when 的标签体(正常输出标签体的内容), 
		     同时把 flag 设置为 false<br>
		* 若 when 的 test 为 true, 且 when 的父标签的 flag 为 false, 则不执行标签体. <br>
		* 若 flag 为 true, otherwise 执行标签体. <br>
	</p>
	
	<hr>
	<!-- 使用一个 EL 的自定义函数 -->
	${fn:length(param.name) } 
	<br><br>
	
	${fn:toUpperCase(param.name1) }
		
	<br><br>
	<!-- 测试自定义的 EL 函数 -->
	${wss:concat(param.name1, param.name2)}

</body>
</html>