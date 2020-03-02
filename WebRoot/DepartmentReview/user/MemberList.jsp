<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'MemberList.jsp' starting page</title>
    
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
    		<th>班级</th>
    		<th>评议名单</th>
    	</tr> 
 <c:forEach items="${MemberList }" var="member">
<tr bordercolor="rgb(78,78,78)">
<td>${member.department }</td>
<td>${member.major }</td>
<td>${member.classno }</td>
<td><a href="<c:url value='/MemberListLoadFileServlet?department=${member.department }&major=${member.major }&classno=${member.classno }'/>">评议名单下载</a></td>
</c:forEach>
 </table>


  </body>
</html>
