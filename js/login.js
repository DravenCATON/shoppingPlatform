$(document).ready(function(){
	setInterval(function() {
		$("img[src*=竖版]:visible").hide().next().show().end().appendTo($("#col-left"));
	}, 
	2000);
	
	$("#loginForm").validate(
	{
		rules:{
			username:"required",
			password:"required",
		},
		messages: {
			username: "请输入用户名",
			password: "请输入密码"
		}
	}
	)
})
