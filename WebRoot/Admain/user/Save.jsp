<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Save.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
  <style type="text/css">
	body {background: rgb(237,216,231);}
 </style>
  </head>
  
  <body>
    <h1>提交申请资助审核通过学生录入数据库：</h1>
    <a href="<c:url value='/ApplicationServlet?method=addToDatabase'/>">提交</a>
    ${addMsg }
  </body>
</html>
