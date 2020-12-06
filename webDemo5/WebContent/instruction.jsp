<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2>MVC案例</h2>
     <h4>一、使用技术</h4>
     <p>
	     MVC 设计模式：JSP、Servlet，POJO<br>
	              数据库使用 MySQL <br>
	              连接数据库需要使用 C3P0 数据库连接池 <br>
	     JDBC 工具采用 DBUtils <br>
	              页面上的提示操作使用 jQuery <br>
     </p><hr>
     
     <h4>二、难点</h4>
     <p>
	               多个请求用一个servlet <br>
	               模糊查询 <br>
	               在创建和修改时，验证用户名是否已经被占用 <br>
     </p><hr>
     
     <h4>三、架构</h4>
     <p>
	     1.&nbsp;view层:jsp，1.1呈现数据；1.2接收输入；1.3js代码给出提示<br>
	     2.&nbsp;control层:servlet，与jsp进行交互，2.1获取请求参数，2.2验证请求参数的合法性：验证失败，需要返回页面，并给出提示信息
		   成功时把请求参数封装为一个 JavaBean，调用 DAO 的方法获取返回的结果，把返回的结果放入到 request 中，响应页面：转发、重定向<br>
		 3.&nbsp;Model层：DAO,获取数据库连接,执行 CRUD 操作,返回结果<br>
		 逐层往下，不可跨层
	 </p><hr>
	 
     <h4>四、详细实现</h4>
     <p>
     	编写顺序：1.先设计数据表；2.写DAO；3.再写Servlet和JSP；<br><br>
     	1.hello数据库下，新建Users表<br>
     	2.增删改查：<br>
     	<font color="red">***</font>（1）DAO类，（2）JdbcUtils类，（3）UserDao接口，（4）实现3接口并继承1类的 UerDAOJdbcImpl类<br>
     	
     	(1)DAO工具类：update() get() getForList() getForValue() ，输入String sql<br>
     	&nbsp;&nbsp;&nbsp;&nbsp;依赖于dbutils包<br>
     	
     	(2)JdbcUtils工具类：getConnection() release()<br>
     	&nbsp;&nbsp;&nbsp;&nbsp;依赖于C3P0包(两个)，导入mysql包<br>
     	
     	(3)UserDao接口：根据需求的增删改查任务，getForListWithCriteriaUser() getAll() save() get() delete() update()<br>
     	&nbsp;&nbsp;&nbsp;&nbsp;实现User实体类<br>
     	
     	(4)UerDAOJdbcImpl类：继承DAO《User》这里T写为具体的User类，实现UserDao<br><br>
     	
     	3.多个请求使用同一个Servlet<br>
     	添加：UserServlet?method=add<br>
     	查询：UserServlet?method=query<br>
     	删除：UserServlet?method=delete<br>
     	1).获取method参数的值 2).调用对应的方法;<br>
     	但是这样添加请求时，1).需要switch和添加方法两处修改；2).method=query这样不安全<br>
     	<br>
     	添加：addUser.do<br>
     	查询：query.do<br>
     	删除：deleteUer.do<br>
     	<font color="red">***</font>url-pattern:*.do <br>
     	1).获取servletPath：去除/和.do，得到addUser或query等；<br>
     	2).利用反射调用servletPath对应的方法；<br>
     	3).创建对应的方法；<br>
     	<font color="red">***</font>此时，已有index.jsp userServlet，从query开始<br>
     	<br>
     	
     	4.模糊查询<br>
     	<font color="red">***</font>全部查询已经实现，注意在index.jsp上的显示问题
     	模糊查询实现：在UserServlet中，将index.jsp传过来的模糊条件生成一个CriteriaUser对象(建立CriteriaUser对象类)，
     	然后在UserDao中添加List《User》 getForListWithCriteriaUser()接口方法(uerdao管实际需求)；
     	再在UserDAOJdbcImpl中将方法实现；
     	再在UserServlet对应方法进行编写；
     	最后将查询结果users从servlet转发到index.jsp<br><br>
     	name:a psd:b balance:c<br>
     	SELECT id,name,psd,balance FROM user WHERE name LIKE '%a%' AND psd LIKE '%b%' AND balance LIKE '%c%'<br>
     	需要在 UserDAO 接口中定义一个 getForListWithCriteriaUser(CriteriaUser cu)。 
     	其中 CriteriaUser 用于封装查询条件：name, psd, balance。因为查询条件很多时候和 domain 类并不相同，所以要做成一个单独的类<br>
		用CriteriaUser不用User，因为手机对象是一个具体的价格属性，查询时可能是价格区间<br>
		<br>
		
		5.删除操作<br>
		从index.jsp的query结果中，超链接delete.do?id=《%=customer.getId()%》
		到servlet对应方法中删除，然后重新显示所有信息在主页，所以重定向到query.do<br><br>
		
		6.添加操作<br>
		从index.jsp点击超链接到newUser2.jsp,再该jsp填写表单，.do跳转到servlet进行判断：<br>
		如果name已有则跳回newUser.jsp,提示name已经存在，<br>
		如果name不存在则存储然后跳转到success.jsp，见webdemo4中例2<br>
		
		7.修改操作<br><font color="red">***</font>
		从index.jsp的query结果中，超链接edit.do?id=《%=customer.getId()%》
		到servlet对应方法：首先查询，对于查询结果<br>
		查询错误或者没有查询到，前往error.jsp<br>
		查询到时，带着查询结果，前往updateuser.jsp，修改之后，跳转到servlet<br>
		检查修改后的name是否已经被占用：<br>
		如果被占用，带着message，请求重发回到updateuser.jsp<br>
		如果没有被占用，则在sevlet调用dao更新并跳回query.do<br>
		注意：当查询出错时（从index携带请求信息发到servlet的edit.do处理，没有查询到时，跳转到error.jsp）当直接从error.jsp跳到updateuser.jsp时<br>
		此时没有携带User对象，User为空,从请求信息request的parameter中获取id等信息<br>
		<br>
		
     </p><hr>
	 
     <h4>五、扩展功能</h4>
     	如将数据存到users.xml，重新写一个类，实现UserDAO接口。<br>
     	只需要在servlet中，private UserDao userDao = new UserDAOJdbcImpl();后面的实现类，
     	改成基于xml的UserDAOXMLImpl实现类即可<br>
     	说明DAO实现类 jdbcutils工具类只是为了帮助实现UserDAO接口实现的工具<br>
     	深入理解面向接口编程：在类中调用接口的方法，而不必关心具体的实现。这将有利于代码的解耦。使程序有更好的可移植性和可扩展性<br>
     	<br>
     	从jdbc到xml的切换，不用修改代码，只需要修改配置文件：<br>
     	（其核心还是servlet中，private UserDao userDao = new UserDAO Jdbc/XML Impl();）<br>
     	建立一个switch.properties 属性type=xml/jdbc<br>
     	通过一个类的方法类获取,UserDAOFactory工厂类，单例，提前建好两个实现类对象，根据type获取对象<br>
     	type=null,所以initServlet读取switch.properties读取type,注意initServlet配置
     <br>
     <p><hr>
     
     <h4>六、使用</h4>
     	<p>6.1页面流程</p>
     	jsp与jsp之间的跳转都通过.do即servlet处理<br>
     	index.jsp→query.do→index.jsp<br>
     	index.jsp→add.do→newUser2.jsp→success.jsp→query.do→index.jsp<br>
     	index.jsp→edit.do→updateuser.jsp→index.jsp<br>
</body>
</html>