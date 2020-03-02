<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'StudentApplicationInfo.jsp' starting page</title>
    
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
    学号：${studentInfo.sid }<br/>
   姓名：${studentInfo.sname }<br/>
   院系：${studentInfo.department }<br/>
   专业：${studentInfo.major }<br/>
   年级：${studentInfo.grade }<br/>
   班级： ${studentInfo.classno }<br/> 
   审核情况：<span style="color: red; font-weight: 900"> ${queryResult }</span><br/>
  
  </body>
</html>
