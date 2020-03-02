<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			font-size:10pt;
			text-align: center;
		}
		div {
			background: #87CEFA; 
			margin: 3px; 
			padding: 3px;
		}
		a {
			text-decoration: none;
		}
	</style>
  </head>
  
  <body>
<div>
	<a href="<c:url value='/StudentServlet?method=personalInformation'/>">个人信息</a>
</div>


<div>
	<a href="<c:url value='/StudentServlet?method=queryApplication'/>">我的资助奖励</a>
</div>
<div>
	<a href="<c:url value='/jsps/ApplicationForm/application.jsp'/>">资助申请管理</a>
</div>
<div>
	<a href="<c:url value='/ApplicationServlet?method=findByDepartmentVerfiy&department=${session.session_student.department }'/>">本院系资助学生名单公布</a>
</div>
<div>
	<a href="<c:url value='/StudentServlet?method=quit'/>">修改账户密码</a>
</div>
<div>
	<a href="<c:url value='/StudentServlet?method=quit'/>">安全退出系统</a>
</div>
  </body>
</html>
