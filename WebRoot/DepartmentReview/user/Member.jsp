<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>提交小组成员名单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <form action="<c:url value='/MemberListUpLoadServlet'/>" method="post" enctype="multipart/form-data">

	院系：<input type="text" name="department"/><br/>
	专业：<input type="text" name="major"/><br/>
	班级：<input type="text" name="classno"/><br/>
	 评审小组成员名单上传：<input type="file" name="ApplicationForm"/><br/>
	<input type="submit" value="提交"/>
	<p style="color: red; font-weight: 900">${upload }</p>

	<br/>
	<br/>   
   </form>
   <a href="<c:url value='/MemberListLoadServlet'/>">北京科技大学天津学院佳通经济困难学生评议小组成员名单-模板</a><br/>
  </body>
</html>
