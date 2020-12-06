<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>MVC</h2>
	<p>模型model 视图view 控制器control</p>
	<p>模型为多个视图提供数据，模型代码写一次被多个视图重用</p>
	<p>视图向用户显示下相关的数据，接收用户输入，不进行业务处理</p>
	<p>接收用户输入，决定调用哪一个模型和哪一个视图完成用户需求，从而返回数据</p>
	<p>客户端访问，服务调用servlet，servlet转向jsp页面进行显示</p>
	<p>servlet作为控制器</p>
	<p>jsp使用JSTL，servlet调用POJO去访问数据库</p>
	<br>
	
	<h3>例1</h3>
	<p>将hello数据库中person表显示出来，即查询</p>
	<p>1.demo1_1发get 请求到 Demo1_queryServlet，由服务器调用do_get方法</p>
	<p>2.Demo1_DAO的getAll方法获取person的list对象，JDBC查询数据表得到list</p>
	<p>3.创建Dao对象，调用getall方法，返回list</p>
	<p>把list放入request请求的转发与重定向到显示的jsp demo1_2.jsp</p>
	<p>4.得到request中的list对象</p>
	<p>遍历list，进行显示</p>
	<h5>附加题：增加删除功能</h5>
	<p>在显示的每行添加《a》，发出删除请求到Demo1_deleteServlet,处理删除,再转发到demo1_3.jsp</p>
	<p>点击《a》时， 传递id给Demo1_deleteServlet ？id=《%=person.getId》</p>
	<a href="demo1_1.jsp">前往demo1_1.jsp</a>
	<br>
	<HR>
	<br>
	
	<h3>例2</h3>
	<p>2.1添加User到数据库</p>
	<p>在demo2_1.jsp填写表单users信息，提交到Demo2_addServlet处理</p>
	<p>在Demo2_addServlet中，封装User对象，调用Demo2_DAO的save方法执行保存操作</p>
	<p>重定向到demo2_2.jsp</p>
	<p>通过时，页面跳转如下：demo2_1.jsp → Demo2_addServlet → demo2_2.jsp</p>
	<p>2.2检验name是否已经被占用</p>
	<p>调用Demo2_DAO的方法检查，如果返回值>0，则请求转发方式来响应demo2_1.jsp，并通知已有，且保留表单的值</p>
	<p>使demo2_1.jsp的表单可以回显：在Demo2_addServlet.getAttribut("message")</p>
	<p>未通过时，页面跳转如下：demo2_1.jsp → Demo2_addServlet → demo2_1.jsp 
	(因为请求转发，只有一个request，回显添加的name直接用request.getAttr...)</p>
	<a href="demo2_1.jsp">前往demo2_1.jsp</a>
	<br><br>
</body>
</html>