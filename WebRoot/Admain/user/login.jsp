<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
      <title>登录</title>  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
    <link rel="stylesheet" href="./login.css" type="text/css">
  </head>
  
  <body>
    <div class="login">
    <div class="login_title">
        <p>北京科技大学天津学院学生资助管理系统</p>
    </div>
    <div class="login_main">
        <div class="main_left"></div>
        <div class="main_right">
        	<div><p style="color: red; font-weight: 900">${msg }</p></div>
            <div class="right_title">用户登录</div>
            <form action="<c:url value='/AdmainServlet'/>" method="post">
            <input type="hidden" name="method" value="login"/>
                <div class="username">
                    <input type="text" placeholder="请输入用户名"  name="iid" value="${form.hid }"/>
                </div>
                <div class="password">
                   
                    <input type="password" placeholder="请输入密码" name="ipassword" value="${form.hpassword }"/>
                </div>
                
                 <div class="denglu"> <input type="submit" value="登录"/></div>
				<center><p style="margin-top:20px;font-size:12px;color:#FA6F03;">登录遇到问题，请联系管理员</p></center>
         
            </form>
        </div>
        <div class="picture"><img src="menu/img/校园风景2(1).jpg" /></div>
    </div>
    <div class="login_footer">
        <p class="name">版权所有：Cuco</p>
		<p>建议浏览器：IE8及以上、360、谷歌、Firefox v22</p>
        <p>技术支持：北京科技大学天津学院 &nbsp;&nbsp;联系电话：1335427190 技术博客：<a href="https://blog.csdn.net/yangyiyun199863">Cuco</a></p>
        
    </div>
</div>

<script type="text/javascript"> (function() { var s = "_" + Math.random().toString(36).slice(2); document.write('<div style="" id="' + s + '"></div>'); (window.slotbydup = window.slotbydup || []).push({ id: "u4923786", container:  s }); })(); </script><script type="text/javascript" src="//cpro.baidustatic.com/cpro/ui/c.js" async="async" defer="defer" ></script>
  </body>
</html>
