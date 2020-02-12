$(document).ready(function(){	
	setInterval(function() {
		$("img[src*=竖版]:visible").hide().next().show().end().appendTo($("#col-left"));
	}, 
	2000);
	
	$("#registerForm").validate(
	{
		rules:{
			username:"required",
			password:"required",
			againPassword:{
				required:true,
				equalTo:"#password"
			}
		},
		messages: {
			username: "请输入用户名",
			password: "请输入密码",
			againPassword:{
				required:"请再次确认密码",
				equalTo:"两次输入的密码不正确"
			}
		}
	})
	$("#username").blur(function(){
		$("#username").valid();
	})
	
	$("#password").blur(function(){
		$("#password").valid();
	})
	
	$("#againPassword").blur(function(){
		$("#againPassword").valid();
	})
	

})