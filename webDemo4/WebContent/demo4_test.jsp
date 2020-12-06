<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导入标签库(描述文件) -->    
<%@taglib uri="http://www.wss.com/mytag/core" prefix="short" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<short:wss value="haha" count="2"/>
	<short:max num2="1" num1="2"/>
	<short:readerFile src="/WEB-INF/note.txt"/>
	
	<hr><p>
	1.实现simpleTag接口,复写setJspContext 获取pageContext，类变量；doTag方法；注意类中属性全为String类型<br>
	2.注意tld文件的位置，在web-inf下；<br>
	带属性时，tld文件中声明好attribute即可<br>
	在接口实现类中，获取属性，在dotag中对属性进行处理，包括是否属性值是否接受el表达式等<br>
	</p>
	
	<hr>
</body>
</html>