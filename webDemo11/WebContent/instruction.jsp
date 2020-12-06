<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>使用数据库存上传文件名</h3>
	实现多个文件上传<br>
	并且在数据库存储上传文件名路径等信息<br>
	并且实现上传文件的下载<br>
	
	<br><hr><br>
	
	upload.jsp : jquery实现新增一个附件<br>
	对文件名和文件大小进行验证<br>
	> 在 upload.jsp 页面上使用 jQuery 实现 "新增一个附件", "删除附件". 但至少需要保留一个.<br>
	> 对文件的扩展名和文件的大小进行验证. 以下的规则是可配置的. 而不是写死在程序中的. <br>
		>> 文件的扩展名必须为 .pptx, docx, doc<br>
		>> 每个文件的大小不能超过 1 M<br>
		>> 总的文件大小不能超过 5 M.<br>
	> 若验证失败, 则在 upload.jsp 页面上显示错误消息: <br>
		>> 若某一个文件不符合要求: xxx 文件扩展名不合法 或 xxx 文件大小超过 1 M<br>
		>> 总的文件大小不能超过 5 M.
	> 若验证通过, 则进行文件的上传操作<br>
		>> 文件上传, 并给一个不能和其他文件重复的名字, 但扩展名不变<br>
		>> 在对应的数据表中添加一条记录. <br>
		
	<br><hr><br>
	
	<h3>代码顺序</h3>
	阶段一：upload.jsp→upload.properties→listener(先util.uploadproperties，单例保存所有参数)
	→servlet读取到properties中属性即可<br>
	阶段二：<br>
	servlet:<br>
	1.servlet1.getServletFileUpload方法：根据properties属性，生成ServletFileUpload upload对象<br>
	2.建立一个fileUploadBean.java，存储table中每条上传信息<br>
	3.回到servlet中解析:<br>
	//3.1. 构建 FileUploadBean 的集合, 同时填充 uploadFiles：buildFileUploadBeans(items, uploadFiles)方法<br>
	//3.2. 校验扩展名 vaidateExtName(beans)方法<br>
	//3.4. 进行文件的上传操作 upload方法<br>
	//3.5. 把上传的信息保存到数据库中 saveBeans(beans)方法<br>
	//3.6. 删除临时文件夹的临时文件 FileUtils.delAllFile(TEMP_DIR)<br>
	
	
	
</body>
</html>