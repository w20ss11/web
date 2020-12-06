<%@page import="cn.wss.mvc.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		
		String id = null;
		String oldName = null;
		String name = null;
		String psd = null;
		String balance = null;
		
		User user = (User)request.getAttribute("user");
		if(user != null){
			id = user.getId() + "";
			oldName = user.getName();
			name = user.getName();
			psd = user.getPsd();
			balance = user.getBalance().toString();
		}else{
			id = request.getParameter("id");
			oldName = request.getParameter("oldName");
			name = request.getParameter("oldName");
			
			psd = request.getParameter("psd");
			balance = request.getParameter("balance");
		}
	%>
	
	<c:if test="${requestScope.message != null }">
		<br>
		<font color="red">${requestScope.message }</font>
		<br>
		<br>
	</c:if>
	
	<c:set var="id" value="${user != null ? user.id : param.id }"></c:set>
	<c:set var="oldName" value="${user != null ? user.name : param.oldName }"></c:set>
	<c:set var="name" value="${user != null ? user.name : param.oldName }"></c:set>
	<c:set var="psd" value="${user != null ? user.psd : param.psd }"></c:set>
	<c:set var="balance" value="${user != null ? user.balance : param.balance }"></c:set>
	
	
	
	<!-- ------------------------------------------------------------ --><hr>
	<form action="update.do" method="post">
	
		<input type="hidden" name="id" value="<%= id %>"/>
		<input type="hidden" name="oldName" value="<%= oldName %>"/>
	
		<table>
			<tr>
				<td>userName:</td>
				<td><input type="text" name="name" 
					value="<%= name %>"/></td>
			</tr>
			<tr>
				<td>psd:</td>
				<td><input type="text" name="psd" 
					value="<%= psd %>"/></td>
			</tr>
			<tr>
				<td>balance:</td>
				<td><input type="text" name="balance" 
					value="<%= balance %>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form>
	
	<form action="update.do" method="post">
	
		<input type="hidden" name="id" value="${id }"/>
		<input type="hidden" name="oldName" value="${oldName }"/>
	
		<table>
			<tr>
				<td>name:</td>
				<td><input type="text" name="name" 
					value="${name }"/></td>
			</tr>
			<tr>
				<td>psd:</td>
				<td><input type="text" name="psd" 
					value="${psd }"/></td>
			</tr>
			<tr>
				<td>balance:</td>
				<td><input type="text" name="balance" 
					value="${balance }"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"/></td>
			</tr>
		</table>
	</form>
</body>
</html>