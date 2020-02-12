<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/shoppingCar.css" rel="stylesheet" type="text/css">
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
<script src="js/shoppingCar.js" type="text/javascript"></script>
<title>shoppingCar</title>
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
		<div id="allDiv">
		<label for="all">全选：</label>
		<input name="all" type="checkbox" id="allCheckbox"/>
		</div>
		<br/>
		<hr/>
		<br/>
		<div id="allShoppingCar">
			<table>
			       
			</table>
		</div>
		<div id="clearShoppingCar"><button id="clearShoppingCarButton">清空购物车</button></div>
	</div>
	
	<div id="identify">
	 	<p>您是否确定清空购物车</p>
		<button id="yes">确定</button><button id="no">不确定</button>
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