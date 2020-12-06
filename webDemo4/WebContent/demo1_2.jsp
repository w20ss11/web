<%@page import="cn.wss.mvc.Demo1_Person"%>
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
	<h3>demo1_2 显示所有person</h3>
	<% 
		@SuppressWarnings("unchecked")
		List<Demo1_Person> ps = (List<Demo1_Person>)request.getAttribute("persons");
	%>
	 
	<table border="1" cellpadding="10" cellspacing="0">
	
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>sex</th>
			<th>birth</th>
		</tr>
		
		<% 
			for(Demo1_Person person: ps){
		%>
				<tr>
					<td><%= person.getId() %></td>
					<td><%= person.getName() %></td>
					<td><%= person.getAge() %></td>
					<td><%= person.getSex() %></td>
					<td><%= person.getBirth() %></td>
					<td><a href="Demo1_deleteServlet?id=<%=person.getId() %>">Delete</a></td>
				</tr>
		<%		
			}
		%>
	
	</table>
	
</body>
</html>