<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>newUser</title>
</head>
<body>
	<% 
		Object msg = request.getAttribute("message");
		if(msg != null){
	%>
			<br>
			<font color="red"><%= msg %></font>
			<br>
			<br>
	<%
		}
	%>
	
	<c:if test="${requestScope.message != null }">
		<br>
		<font color="red">${requestScope.message }</font>
		<br>
		<br>
	</c:if>
	
	
	<!-- ---------------------------------------------------------- --><hr>
	<form action="addUser.do" method="post">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="name" 
					value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"/></td>
			</tr>
			<tr>
				<td>psd:</td>
				<td><input type="text" name="psd" 
					value="<%= request.getParameter("psd") == null ? "" : request.getParameter("psd") %>"/></td>
			</tr>
			<tr>
				<td>balance:</td>
				<td><input type="text" name="balance" 
					value="<%= request.getParameter("balance") == null ? "" : request.getParameter("balance") %>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="addUser"/></td>
			</tr>
		</table>
	</form>
	
	<form action="addUser.do" method="post">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="name" value="${param.name }"/></td>
			</tr>
			<tr>
				<td>psd:</td>
				<td><input type="text" name="psd" value="${param.psd }"/></td>
			</tr>
			<tr>
				<td>balance:</td>
				<td><input type="text" name="balance" value="${param.balance }"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加"/></td>
			</tr>
		</table>
	</form>
	<!-- ------------------------------------------------------- --><hr>
</body>
</html>