<%@page import="java.util.Date"%>
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
	<form action="demo3_EL.jsp" method="post">
		
		username1(回显): <input type="text" name="username" 
			value="<%= request.getParameter("username") == null ? "" : request.getParameter("username")%>"/>
		<br><br>
		
		username2(获取): <%=request.getParameter("username") %>
		
		<br><br>
		username3(EL): <input type="text" name="username" 
			value="${param.username }"/>
		<input type="submit" value="Submit"/>
		
		<br><br><!-- -------------------------------------- --><hr>
		
		<jsp:useBean id="person" class="cn.wss.mvc.Demo2_Person" scope="session"></jsp:useBean>
		<jsp:setProperty property="age" value="12" name="person"/>
		
		age: 
		<% 
			Demo2_Person person2 = (Demo2_Person)session.getAttribute("person");
			out.print(person2.getAge());
		%>
		<br>
		age: <jsp:getProperty property="age" name="person"/>
	
		<br>
		<br>
		
		<% 
			application.setAttribute("time", new Date());
		%>
		
		<a href="demo3_2EL.jsp?score=89&name=A&name=B&name=C">To demo3_2EL.jsp Page</a>
		
		
		
		
		<br><br><!-- -------------------------------------- --><hr>
		
		<p>所有 EL表达式 都是以  $ {  为起始、以  }  为结尾的<br>
		</p>
	</form>
</body>
</html>