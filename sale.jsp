<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/sale.css" rel="stylesheet" type="text/css">
<!-- 引入jquery的库 -->
<script src="js/plugin/jquery-3.4.1.js" type="text/javascript"></script>
<!-- 引入validation插件的库 -->
<script src="js/plugin/jquery.validate.js" type="text/javascript"></script>
<script src="js/plugin/messages_zh.js" type="text/javascript"></script>
<!-- 引入form插件的库 -->
<script src="js/plugin/jquery.form.js" type="text/javascript"></script>
<!-- 引入cookie插件的库 -->
<script src="js/plugin/jquery.cookie.js" type="text/javascript"></script>
<!-- 引入自己的js文件 -->
<script src="js/sale.js" type="text/javascript"></script>
<title>sale</title>
</head>
<body>
	<div id="navTop">
		<img src="img/LOGO.png" id="logo"> <a class="nav" id="main"
			href="index.jsp">主页</a> <a class="nav" id="shoppingCar"
			href="shoppingCar.jsp">购物车</a> <a class='nav' id='order'
			href="order.jsp">我的订单</a> <a class="nav" id="sale" href="sale.jsp">发布商品</a>
		<a class="nav" id="myself" href="myself.jsp"><img id="headImage" src=""></a>
	</div>

	<div id="smallNav">
		<a class="navSmall" id="main"
			href="index.jsp">主页</a> <a class="navSmall"
			href="shoppingCar.jsp">购物车</a> <a class='navSmall'
			href="order.jsp">我的订单</a> <a class="navSmall" href="sale.jsp">发布商品</a>
		<a class="navSmall" href="myself.jsp">个人信息</a>
	</div>
	
	<div id="userInformation">
		<div id="userInformationInside">
			<p id="pName">姓名：</p>
			<p id="pSex">性别：</p>
			<p id="pAddress">地址：</p>
		</div>
	</div>
	
	<div id="mainContent">
		<h1 id="header">已发布的商品</h1>
		<br/>
		<hr/>
		<br/>
		<div id="allProduct">
		</div>
		<br/>
		<hr/>
		<div id="sendProdutDiv"><a href="sendProduct.jsp" id="sendProdut">我要发布</a></div>
	</div>
</body>
</html>