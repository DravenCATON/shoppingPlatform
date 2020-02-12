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
			$("#headImage").attr("src","img/headImage/header"+jsonObj.uid+".jpg")
			$("#pName").text("姓名："+jsonObj.name);
			$("#pSex").text("性别："+jsonObj.sex);
			$("#pAddress").text("地址："+jsonObj.address);
			$.each(jsonObj.setProduct,function(index,value){
			     $("#allProduct").prepend(
		    		 "<div class='productDiv' id="+value.pid+">"+
						"<img src='img/product/product"+value.pid+".png' class='productImg'>"+
						"<p class='price'>"+value.price+"</p>"+
						"<p class='name'><a href='showProduct.action?id="+value.pid+"' class='nameA'>"+value.name+"</a></p>"+
					"</div>"
			     );
			})
		});
	}
	else{
		window.location.replace("login.jsp");
	}
	
})

