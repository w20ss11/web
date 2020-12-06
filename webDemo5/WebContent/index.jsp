<%@page import="cn.wss.mvc.domain.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var content = $(this).parent().parent().find("td:eq(1)").text();
			var flag = confirm("确定要是删除" + content + "的信息吗?");
			return flag;
		});
	});
</script>
</head>
<body>
	<form action="query.do" method="post">
		<table>
			<tr>
				<td>userName:</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>psd:</td>
				<td><input type="text" name="psd"/></td>
			</tr>
			<tr>
				<td>balance:</td>
				<td><input type="text" name="balance"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Query"/></td>
				<td><a href="newUser2.jsp">Add New User</a></td>
			</tr>
		</table>
	</form>
	
	<br><br>
	
	<!-- ------------------------------------------------  ------------------ --><hr>
	<%
		List<User> users = (List<User>)request.getAttribute("users");
		if(users!=null && users.size()>0){
			%>
			<br>
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<th>id</th>
					<th>name</th>
					<th>psd</th>
					<th>balance</th>
				</tr>
				<%
					for(User user:users){
						%>
						<tr>
							<td><%= user.getId() %></td>
							<td><%= user.getName() %></td>
							<td><%= user.getPsd() %></td>
							<td><%= user.getBalance() %></td>
							<td><a href="edit.do?id=<%= user.getId() %>">Update</a>
							    <a href="delete.do?id=<%= user.getId() %>" class="delete">Delete</a>
							</td>
						</tr>
						<%
					}
				%>
			</table>
			<%
		}
		
	%>
	<br><br><hr>
	
	<c:if test="${!empty requestScope.users }">

		<hr>	
		<br><br>
	 
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>psd</th>
				<th>balance</th>
				<th>UPDATE\DELETE</th>
			</tr>
			
			<c:forEach items="${requestScope.users }" var="person">
					
					<tr>
						<td>${person.id }</td>
						<td>${person.name }</td>
						<td>${person.psd }</td>
						<td>${person.balance }</td>
						<td>
							<c:url value="/edit.do" var="editurl">
								<c:param name="id" value="${person.id }"></c:param>
							</c:url>
							<a href="${editurl }">UPDATE</a>
							<c:url value="/delete.do" var="deleteurl">
								<c:param name="id" value="${person.id }"></c:param>
							</c:url>
							<a href="${deleteurl }" class="delete">DELETE</a>
						</td>
					</tr>
			
			</c:forEach>
			
		</table>
	</c:if>
</body>
</html>