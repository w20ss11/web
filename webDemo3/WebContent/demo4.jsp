<%@page import="java.util.Date"%>
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
		//1. jsp模板元素：html中的元素内容
		//2. jsp表达式 将要输出的变量表达式直接封装在《%= 和%》之中
		Date date = new Date();
		out.print(date);
	%>
	<br>
	<!-- JSP表达式 -->
	<%= date %>
	
	<%
		//3. 代码片段在《% %》中
		String ageStr = request.getParameter("age");
	    //网址后加 ？age=29
		Integer age = Integer.parseInt(ageStr);
		if(age>18){
			//out.println("成人"); //多个脚本片段可以相互访问
	%>
			成人。。。
	<%
		}else{
			//out.println("未成年");
	%>
			未成年。。。
	<%
		}
	%>
	
	<%!
		//4. JSP声明 《%！和%》中的代码会被插入在servlet的_jspService方法的外面
		//这些java代码在service方法里面，所以不能声明方法
		void test(){}//JSP页面中 但是几乎不用
	%>
	<!-- HTML注释 -->
	<%-- JSP注释 --%>jsp注释可以阻止java代码（<% %>）执行
</body>
</html>