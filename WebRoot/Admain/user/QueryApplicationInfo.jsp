<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'QueryApplicationInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {background: rgb(237,216,231);}
	table {font-family: 宋体; font-size: 11pt; border-color: rgb(78,78,78);  width: 90%;}
	#th {background: rgb(78,78,78);}
</style>
  </head>
  
  <body>
   <table align="center" border="1" cellpadding="0" cellspacing="0">
    <tr id="th" bordercolor="rgb(78,78,78)">
    		<th>院系</th>
    		<th>专业</th>
    		<th>年级</th>
    		<th>班级</th>
    		<th>姓名</th>
    		<th>学号</th>
    		<th>申请文件</th>
    		<th>申请附件</th>
    	</tr> 
<tr bordercolor="rgb(78,78,78)">
<td>${application.department }</td>
<td>${application.major }</td>
<td>${application.grade }</td>
<td>${application.classno }</td>
<td>${application.name }</td>
<td>${application.id }</td>
<td><a href="<c:url value='/ApplicationLoadFileServlet?id=${application.id }'/>">申请文件</a></td>
<td><a href="<c:url value='/ApplicationLoadPictureServlet?id=${application.id }'/>">附件图片</a></td>
 </table>
  </body>
</html>
