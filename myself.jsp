<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=600,user-scaleable=no">
<title>userInformation</title>
<link href="css/myself.css" rel="stylesheet" type="text/css">
<!-- 引入jquery的库 -->
<script src="js/plugin/jquery-3.4.1.js" type="text/javascript"></script>
<!-- 引入jquery-form的库 -->
<script src="js/plugin/jquery.form.js" type="text/javascript"></script>
<!-- 引入cookie插件的库 -->
<script src="js/plugin/jquery.cookie.js" type="text/javascript"></script>
<!-- 引入自己的js文件 -->
<script src="js/myself.js" type="text/javascript"></script>
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
	
	<form id="userForm" action="updateUser" method="post" enctype="multipart/form-data">
		<div id="mainContent">
			<div id=col-left>
				<div id="photoContainer">
					<img id="photo" src="" />
				</div>
				<br/>
				头像照片
		        <div id="uploadDiv">
		        	<input class="uploadInput" type="file" placeholder="" name="file">修改头像照片
		        </div>
		        <br/>
		        <div id="uploadTip"></div>
			</div>
			<div id=col-right>
				<div id="nameDiv"><label id="nameLabel">名字：</label><br><input type="text" placeholder="请输入名字" name="name" id="name" value=""></div>
				<div id="sexDiv">
					<input type="hidden" name="id" id="id" value="">
					<input type="radio" class="radio" id="boyRadio" name="sex" value="男">
					<input type="radio" class="radio" id="grilRadio" name="sex" value="女">
					<label id="boy">男:</label><img id="boyImg" src="img/男.png">
					<label id="gril">女:</label><img id="grilImg" src="img/女.png">
				</div>
				<div id="addressDiv"><label id="addressLabel">地址：<br/></label><textarea rows="5" cols="20" placeholder="请输入地址" name="address" id="address"></textarea></div>			
				<input type="submit" value="确定" id="identify">
				
			</div>
		</div>
	</form>
	<div id="backToLoginDiv"><button id="backToLogin">退出登录</button></div>
	<div id="userInformation">
		<div id="userInformationInside">
			<p id="pName">姓名：</p>
			<p id="pSex">性别：</p>
			<p id="pAddress">地址：</p>
		</div>
	</div>
</body>
</html>