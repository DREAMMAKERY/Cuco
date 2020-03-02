<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>提交个人申请</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="<c:url value='/ApplicationUpLoadServlet'/>" method="post" enctype="multipart/form-data">
	
	姓名：<input type="text" name="name"/><br/>
	学号：<input type="text" name="id"/><br/>
	院系：<input type="text" name="department"/><br/>
	年级：<input type="text" name="grade"/><br/>
	专业：<input type="text" name="major"/><br/>
	班级：<input type="text" name="classno"/><br/>
	 家庭经济困难学生认定申请表上传：<input type="file" name="ApplicationForm"/><br/>
	 家庭经济困难学生认定附件上传：<input type="file" name="ApplicationPicture"/><br/>
	<input type="submit" value="提交"/>
	<p style="color: red; font-weight: 900">${upload }</p>
	
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>   
   </form>
   <a href="<c:url value='/DownloadServlet'/>">北京科技大学天津学院家庭经济困难学生认定申请表模板下载</a><br/>
  </body>
</html>
