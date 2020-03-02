<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background: rgb(78,78,78);color: white;">
<h1 style="text-align: center; ">北京科技大学天津学院学生资助管理系统</h1>


<div style="font-size: 10pt;">
		<c:choose>
		<c:when test="${empty sessionScope.session_admain }">
			<a href="<c:url value='/Admain/user/login.jsp'/>" target="_parent">登录</a> |&nbsp; 
		</c:when>
		<c:otherwise>
			您好：${sessionScope.session_admain.iid }&nbsp;&nbsp;|&nbsp;&nbsp;	
		</c:otherwise>
	</c:choose>
</div>
  </body>
</html>
