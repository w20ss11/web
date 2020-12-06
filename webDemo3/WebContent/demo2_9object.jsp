<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% //9个隐含对象,没有声明就可以使用的对象
	
		//1. request 运行后，在网址最后加上    ?name=wss
		String name = request.getParameter("name");
		System.out.println(name);
		
		//2. response 在jsp中几乎不会调用response的方法
		System.out.println(response instanceof HttpServletResponse);
		
		//3. pageContext: 页面上下文，可以获取到其他8个隐含对象，也可以获取到当前页面的其他信息
		//学习自定义标签时会用到
		ServletRequest req = pageContext.getRequest();
		System.out.print(req==request);
		
		//4. session 代表浏览器和服务器的一次对话 HttpSession的一个对象
		System.out.println(session.getId());
		
		//5. application 代表当前web应用，是ServletContext对象（web.xml中参数）
		System.out.println(application.getInitParameter("param-name"));
		
		//6. config当前JSP对应的Servlet的ServletConfig对象（几乎不使用）
		System.out.println(config.getInitParameter("param-name"));
		
		//7. out JspWriter对象，调用out.println()可以直接把字符串打印到浏览器上
		out.println("hah");
		out.println("<br>");
		out.println("hah");
		
		//8. Object page 几乎不用，指向当前JSP对应Servlet对象的应用，Object类型
		out.println(page);
		
		//9. exception 
		
	%>

</body>
</html>