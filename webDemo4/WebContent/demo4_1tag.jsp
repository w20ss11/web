<%@page import="java.util.ArrayList"%>
<%@page import="cn.wss.mvc.Demo2_Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	<jsp:forward page="demo4_2tag.jsp"></jsp:forward>
</body>
</html>