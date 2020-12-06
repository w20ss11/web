<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 从RequstDemo9出利用request转到到此jsp 并用request域传送数据 -->
	${date}   
    <!-- 实际开发中 是不允许jsp页面中出现java代码的，都是用自定义标签和EL表达式替换java代码 -->  
    <%  
        //request的getParameter方法得到的是请求数据，getAttribute方法得到的是request域里的数据  
        String message = (String)request.getAttribute("data");  
        out.write(message);  
    %>  
</body>
</html>