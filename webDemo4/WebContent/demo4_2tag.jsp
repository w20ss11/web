<%@page import="cn.wss.mvc.Demo2_Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 在页面上对 request 中的 persons 属性进行遍历, 打印 id, name, age -->
	<c:forEach items="${requestScope.persons }" var="person">
		--${person.id }, ${person.name }, ${person.age }<br>
	</c:forEach>
	<hr>
	
	<%
		@SuppressWarnings("unchecked")
		List<Demo2_Person> persons = (List<Demo2_Person>)request.getAttribute("persons");
	
		if(persons != null){
			for(Demo2_Person person: persons){
	%>
				<%= person.getId() %>, <%= person.getName() %>, <%= person.getAge() %><br>
	<%			
			}
		}
	%>
	
	<hr>
	1.添加两个包 jstl.jar standraid.jar
	2.加载《%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%》<br>
	用户定义的一种自定义的jsp标记 。当一个含有自定义标签的jsp页面被jsp引擎编译成servlet时，
	tag标签被转化成了对一个称为 标签处理类 的对象的操作。于是，当jsp页面被jsp引擎转化为servlet后，
	实际上tag标签被转化为了对tag处理类的操作。 <br><br>
	
	标签分为带内容的，带属性的<br><br>
	
	自定义标签开发：<br>
	1.编写完成标签功能的 Java 类(标签处理器) SimpleTag接口<br>
	2.编写标签库描述(tld)文件，在tld文件中对自定义中进行描述，点url可以看到<br>
	4.在 JSP 页面中导入和使用自定义标签<br>
	<br>
	
</body>
</html>