<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>上传</h3>

	1.post方式，网址最后不能加上上传文件<br>
	2.编码方式：enctype="multipart/form-data"<br>
	<br>
	
	<form action="uploadServlet" method="post" enctype="multipart/form-data">
		
		File: <input type="file" name="file"/>
		<br>
		<br>
		Desc: <input type="text" name="desc"/>
		<!-- enctype此方式下，getparameter不行，二进制方式提交，所以输入流方式 -->
		<br>
		<br>
		
		<input type="checkbox" name="interesting" value="Reading"/>Reading
		<input type="checkbox" name="interesting" value="Party"/>Party
		<input type="checkbox" name="interesting" value="Sports"/>Sports
		<input type="checkbox" name="interesting" value="Shopping"/>Shopping
		<br>
		<br>
		
		
		<input type="submit" value="Submit"/>
		
	</form>
</body>
</html>