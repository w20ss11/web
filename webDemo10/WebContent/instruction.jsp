<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1.使用流上传</h3>
	<h3>2.使用common-upload组件上传</h3>
	2.1FileItemFactory对象 servletFileUpload对象 parseRequet()方法
	得到list《fileItem》<br>
	2.3所有请求信息都解析为fileItem<br>
	2.4调用fileItem的isFromField判断是文本域还是文件域<br>
	2.5可以同时为文件设置一些复杂的属性,factory.set...如最多总的上传的文件大小setSizeMax，
	如超过，写到一个临时文件夹（setRepository）,设置单个文件最大setFileSizeMax<br>
	index.jsp upload.jsp UploadServlet.java<br>
	
</body>
</html>