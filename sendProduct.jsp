<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/sendProduct.css" rel="stylesheet" type="text/css">
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
<script src="js/sendProduct.js" type="text/javascript"></script>
<title>sendProduct</title>
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
			<p>姓名：</p>
			<p>性别：</p>
			<p>地址：</p>
		</div>
	</div>
	<form id="productForm" action="sendProduct" method="post" enctype="multipart/form-data">
		<div id="mainContent">
			<div id=col-left>
				<div id="photoContainer">
					<img id="photo" src="" />
				</div>
				<br/>
				商品照片
		        <div id="uploadDiv">
		            <input class="uploadInput" type="file" placeholder="" name="productImage">选择您要上传的商品图片
		        </div>
		        <br/>
		        <div id="uploadTip"></div>
			</div>
			<div id=col-right>
				<input type="hidden" id="userId" value="" name="userId">
				<div id="nameDiv"><label id="nameLabel">商品名字：</label><input type="text" placeholder="请输入商品名字" name="name" id="name"></div>
				<div id="priceDiv"><label id="priceLabel">商品价格：<br/>￥</label><input type="number" placeholder="请输入商品价格" name="price" id="price"/></div>
				<input type="submit" value="确定" id="identify">
				<a href="sale.jsp" id="cancel">取消</a>
			</div>
		</div>
	</form>
</body>
</html>