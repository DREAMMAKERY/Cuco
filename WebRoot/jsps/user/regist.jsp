<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>注册</h1>
  <%--
  1.显示errors:字段错误
  2.显示异常错误
  3.回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/StudentServlet'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	学号：<input type="text" name="sid" value="${form.sid }"/>
	<span style="color: red; font-weight: 900">${errors.studentId }</span>
	<br/>
	姓名：<input type="text" name="sname" value="${form.sname }"/>
	<span style="color: red; font-weight: 900">${errors.studentName }</span>
	<br/>
	密　码：<input type="password" name="spassword" value="${form.spassword }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	院系：<select name="department">
  <option value="信息工程系">信息工程系</option>
  <option value="土木工程系">土木工程系</option>
  <option value="材料工程系">材料工程系</option>
   <option value="法律系">法律系</option>
</select><br/>

专业：<select name="major">
  <option value="计算机科学与技术">计算机科学与技术</option>
  <option value="自动化">自动化</option>
  <option value="通信工程">通信工程</option>
   <option value="法律系">法律</option>
      <option value="造价">造价</option>
         <option value="道桥">道桥</option>
</select><br/>

班级：<input type="text" name="classno"/>

	<input type="submit" value="注册"/>
</form>
  </body>
</html>
