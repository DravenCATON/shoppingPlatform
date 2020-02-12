<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>order</title>
<link rel="stylesheet" href="css/order.css"  type="text/css">
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
<script src="js/order.js" type="text/javascript"></script>
</head>
<body>
	<div id="navTop">
		<img src="img/LOGO.png" id="logo"> <a class="nav" id="main"
			href="index.jsp">主页</a> <a class="nav" id="shoppingCar"
			href="shoppingCar.jsp">购物车</a> <a class='nav' id='order'
			href="order.jsp">我的订单</a> <a class="nav" id="sale" href="sale.jsp">发布商品</a>
		<a class="nav" id="myself" href="myself.jsp"><img id="headImage"
			src="img/headImage/header1.jpg"></a>
	</div>

	<div id="smallNav">
		<a class="navSmall" id="main" href="index.jsp">主页</a> <a
			class="navSmall" href="shoppingCar.jsp">购物车</a> <a class='navSmall'
			href="order.jsp">我的订单</a> <a class="navSmall" href="sale.jsp">发布商品</a>
		<a class="navSmall" href="myself.jsp">个人信息</a>
	</div>
	
	<div id="mainContent">
		<div id="bugOrder">
			<h1>
			我的购买
			</h1>
			<br/>
			<hr/>
			<br id="bugBr"/>
		</div>
		<div id="saleOrder">
			<h1>
			我的出售
			</h1>
			<br/>
			<hr/>
			<br id="saleBr"/>
		</div>
		
		
		<div class='userDetailDiv' id="1Div">
			<p class='name2'>伍晓鸣</p>	
			<p class='address'>山东省济南市高新区山东大学齐鲁软件学院</p>
			<p class='phoneNumber'>15322108638</p>
		</div>
	</div>
	
	<div id="identify">
	 	<p>您是否确认订单已经收到</p>
		<button id="yes">确认</button><button id="no">取消</button>
	</div>
	<div id="opacityLevel"></div>
	
	<div id="userInformation">
		<div id="userInformationInside">
			<p id="pName">姓名：</p>
			<p id="pSex">性别：</p>
			<p id="pAddress">地址：</p>
		</div>
	</div>
</body>
</html>