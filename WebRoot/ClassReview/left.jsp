<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>菜单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
<script language="javascript">
var bar1 = new Q6MenuBar("bar1", "学生资助申请-班级初审");
function load() {
	bar1.colorStyle = 2;//配色方案
	//指定图片目录
	bar1.config.imgDir = "<c:url value='/menu/img/'/>";
	bar1.config.radioButton=false;//菜单之间是否相互排斥
	/*
	分类管理：指定要添加的菜单名称（如果菜单名称已存在，不会重复添加）
	查看分类：指要添加的菜单项名称
	<c:url value='/adminjsps/admin/category/list.jsp'/>：指定菜单项时要请求的地址
	body：结果的显示框架页名称
	*/
	bar1.add("班级初审", "审核学生资助申请", "<c:url value='/ApplicationServlet?method=findAll'/>", "body");
	bar1.add("班级初审", "提交小组评审名单", "<c:url value='/ClassReview/user/Member.jsp'/>", "body");
	

	bar1.add("贫困认定办法公布", "查看公布", "<c:url value='/ClassReview/user/public.html'/>", "body");
	

	bar1.add("修改账户信息", "修改账户密码", "<c:url value='/adminjsps/admin/order/list.jsp'/>", "body");
	bar1.add("安全退出系统","退出", "<c:url value='/adminjsps/admin/order/list.jsp'/>", "body");

	//获取div元素
	var d = document.getElementById("menu");
	//把菜单对象转换成字符串，赋值给<div>元素做内容
	d.innerHTML = bar1.toString();
}
</script>

</head>

<body onload="load()" style="margin: 0px; background: rgb(237,216,231);">
<div id="menu"></div>

</body>
</html>
