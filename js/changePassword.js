$(document).ready(function(){
	setInterval(function() {
		$("img[src*=竖版]:visible").hide().next().show().end().appendTo($("#col-left"));
	}, 
	2000);
	
	$("#changePasswordForm").validate(
	{
		rules:{
			username:"required",
			oldPassword:"required",
			newPassword:"required",
			againNewPassword:{
				required:true,
				equalTo:"#newPassword"
			}
		},
		messages: {
			username: "请输入用户名",
			oldPassword: "请输入原密码",
			newPassword: "请输入新密码",
			againNewPassword:{
				required:"请再次确认新密码",
				equalTo:"两次密码输入不一致，请重新输入"
		},
		}
	}
	)
	
	$("#username").blur(function(){
		$("#username").valid();
	})
	
	$("#password").blur(function(){
		$("#password").valid();
	})
	
	
	
	$("#changePasswordButton").bind("click",function(){
		if($("#changePasswordForm").valid()){
			var option={
					url:"changePassword",
					type:'post',
					success:function(data){
						var jsonObj = eval(data);
						if(jsonObj){
							$("#changePasswordForm").hide();
							$("#changePasswordSuccess").show();
						}
						else{
							$("#errorForFail").show();
						}
					},
					error:function(data){
						$("#errorForFail").show();
					}
				}
			$("#changePasswordForm").ajaxForm(option);
		}
	})
	
	$("input").focus(function(){
		$("#errorForFail").hide();
	})
})