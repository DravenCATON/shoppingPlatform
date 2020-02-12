<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>changePassword</title>
<link href="css/changePassword.css" rel="stylesheet" type="text/css">
<!-- 引入jquery的库 -->
<script src="js/plugin/jquery-3.4.1.js" type="text/javascript"></script>
<!-- 引入validation插件的库 -->
<script src="js/plugin/jquery.validate.js" type="text/javascript"></script>
<script src="js/plugin/messages_zh.js" type="text/javascript"></script>
<!-- 引入form插件的库 -->
<script src="js/plugin/jquery.form.js" type="text/javascript"></script>
<!-- 引入自己的js文件 -->
<script src="js/changePassword.js" type="text/javascript"></script>
</head>
<body>
	<img src="img/LOGO.png" alt="宿舍管理系统的logo图" id=logo>
		<div id="father">
			<div id="col-left">
				<img src="img/竖版.jpg" alt="修改密码页面左侧的装饰图" id=leftImg1>
				<img src="img/竖版2.jpg" alt="修改密码页面左侧的装饰图" id=leftImg2>
				<img src="img/竖版3.jpg" alt="修改密码页面左侧的装饰图" id=leftImg3>
			</div>
			<div id="col-right">
				<h1>小纸盒网购平台<br>修改密码</h1>
				<div id=Slogan>乐于生活，每一天。</div>
				<form id="changePasswordForm">
					<label id="errorForFail">用户名或密码错误</label>
					<br />
					<input type="text" name="username" id="username" placeholder="用户名"/>
					<br />
					<input type="password" name="oldPassword" id="oldPassword" placeholder="原密码"/>
					<br />
					<input type="password" name="newPassword" id="newPassword" placeholder="新密码"/>
					<br />
					<input type="password" name="againNewPassword" id="againNewPassword" placeholder="再次确认新密码"/>
					<br />
					<input type="submit" id="changePasswordButton" value="修改密码" />
				</form>
				<a href="register.jsp" id="toRegister">注册</a> <a
				href="login.jsp" id="toLogin">登录</a>
				<div id="changePasswordSuccess">
					已成功修改密码，感谢您的使用
				</div>
			</div>
		</div>
</body>
</html>