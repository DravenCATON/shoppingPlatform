$(document).ready(function(){
	var isDown=false;
	$("#logo").click(function(){
		if(isDown){
			$("#smallNav").slideUp(200).children(".navSmall").hide();
			isDown=false
		}else if($(window).width()<1150&&!isDown){
			$("#smallNav").slideDown(200).children(".navSmall").show();
			isDown=true;
		}
	});
	
	$("#headImage").mouseover(function(){
		$("#userInformation").slideDown(200);
	})
	
	$("#headImage").mouseout(function(){
		$("#userInformation").slideUp(200);
	})
	
	var username=$.cookie("username");
	if(username!="null"){
		$.post("getUser",{'username':username},function(data){
			var jsonObj = JSON.parse(data);
			$("#headImage").attr("src","img/headImage/header"+jsonObj.uid+".jpg");
			$("#pName").text("姓名："+jsonObj.name);
			$("#pSex").text("性别："+jsonObj.sex);
			$("#pAddress").text("地址："+jsonObj.address);
		});
	}else{
		$("#headImage").attr("src","img/headImage/header.png");
	}
	
	$("#addToShoppingCar").click(function(){
		if(username!=null){
			var count=$("#counter").val();
			var dianIndex=$("#headImage").attr("src").lastIndexOf('.');
			var userId=$("#headImage").attr("src").charAt(dianIndex-1);
			var dianIndex2=$("#photo").attr("src").lastIndexOf('.');
			var productId=$("#photo").attr("src").charAt(dianIndex2-1);
			$.post("addToShoppingCar",{'count':count,'userId':userId,'productId':productId},function(data){
				var jsonObj = eval(data);
				if(jsonObj){
					alert("添加成功");
				}
			})
		}
		else{
			alert("请先登录");
			window.location.replace("login.jsp");
		}
	})
	
	$("#shoppingCar").click(function(event){
		if(username!=null){
		}
		else{
			event.preventDefault(); 
			window.location.replace("login.jsp");
		}
	})
	
	$("#order").click(function(event){
		if(username!=null){
		}
		else{
			event.preventDefault(); 
			window.location.replace("login.jsp");
		}
	})
	
	$("#sale").click(function(event){
		if(username!=null){
		}
		else{
			event.preventDefault(); 
			window.location.replace("login.jsp");
		}
	})
	
	$("#myself").click(function(event){
		if(username!=null){
		}
		else{
			event.preventDefault();
			window.location.replace("login.jsp");
		}
	})
})