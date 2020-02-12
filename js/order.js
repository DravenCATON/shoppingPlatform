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
			
			
			
			//加入自己的个人信息
			$("#mainContent").prepend(
					"<div class='userDetailDiv' id='"+jsonObj.uid+"Div'>"+
						"<p class='name2'>"+jsonObj.name+"</p>	"+
						"<p class='address'>"+jsonObj.address+"</p>"+
						"<p class='phoneNumber'>15322108638</p>"+
					"</div>"
				);
			
			
			
			//加入完成自己的个人信息之后加入我已购买的商品订单
			$.each(jsonObj.setOrder,function(index,value){
				var wholePrice=value.product.price*value.number;
				var block="";
				if(value.received){
					block+= "<button class='receiveButton' id='receiveButton' style='display:none'>已收货</button>"+
							"<img class='receiveImg'  src='img/勾.png'>";
							
				}else{
					block+= "<button class='receiveButton' id='receiveButton'>已收货</button>"+
							"<img class='receiveImg' style='display:none' src='img/勾.png'>"+
							"<div style='display:none'>"+value.oid+"</div>";
				}
				
				$("#bugBr").after(
						"<table>"+
						"<tr class="+jsonObj.uid+">"+
						"<td class='content'>"+
							"<img class='product' src='img/product/product"+value.product.pid+".png'>"+
							"<p class='description'><a href='' class='descriptionA'>"+value.product.name+"</a></p>"+
							"<p class='number'>x"+value.number+"</p>"+
						"</td>"+
						"<td class='buyerInformation'>"+
							"<div class='userDiv'>"+
								"<p class='name'>"+jsonObj.name+"</p>"+
								"<img class='userImg' src='img/用户.png'>"+
							"</div>"+
						"</td>"+
						"<td class='price'>总计￥"+wholePrice+"</td>"+
						"<td class='isReceived'>"+
							block+
						"</td>"+
						"</tr>"+
					"</table>"+
					"<p class='time'>"+value.time+"</p>"
				);
			});
			//加入我已购买的商品订单之后为订单上的照片增添事件
			$(".userImg").mouseover(function(){
				var id="#"+$(this).parent().parent().parent().attr("class")+"Div";
				$(id).show();
				var offset = $(this).offset()
				$(id).css("top",offset.top);
				$(id).css("left",offset.left+$(this).width());
			})
			$(".userImg").mouseout(function(){
				$(".userDetailDiv").hide();
			})
			//加入我已购买的商品订单之后为订单上的已收货按钮增添事件
			$(".receiveButton").click(function(){
				$("#identify").show();
				$("#opacityLevel").show();
				var receiveButton=$(this);
				$("#yes").click(function(){
					var oid = receiveButton.siblings("div").text();
					$.post("received",{'orderId':oid},function(){
						window.location.reload();
					})
				})
				$("#no").click(function(){
					$("#identify").hide();
					$("#opacityLevel").hide();
				})
			})
			
			
			//之后再添加我卖出去的订单
			$.each(jsonObj.setOrderSaler,function(index,value){
				var wholePrice=value.product.price*value.number;
				$.post("getUserByOrderId",{'orderId':value.oid},function(data2){
					var jsonObj2 = JSON.parse(data2);
					var block="";
					if(value.received){
						block+= "<td class='isReceived'>"+
								"买家已收货"+
								"</td>";
					}else{
						block+= "<td class='isReceived'>"+
								"买家未收货"+
								"</td>";
					}
						
					$("#saleBr").after(
							"<table>"+
							"<tr class="+jsonObj2.uid+">"+
							"<td class='content'>"+
								"<img class='product' src='img/product/product"+value.product.pid+".png'>"+
								"<p class='description'><a href='' class='descriptionA'>"+value.product.name+"</a></p>"+
								"<p class='number'>x"+value.number+"</p>"+
							"</td>"+
							"<td class='buyerInformation'>"+
								"<div class='userDiv'>"+
									"<p class='name'>买方："+jsonObj2.name+"</p>"+
									"<img class='userImg' src='img/用户.png'>"+
								"</div>"+
							"</td>"+
							"<td class='price'>总计￥"+wholePrice+"</td>"+
								block+
							"</tr>"+
						"</table>"+
						"<p class='time'>"+value.time+"</p>"
					);
					
					
					//之后为我卖出去的订单的买家添加个人信息
					$("#mainContent").prepend(
						"<div class='userDetailDiv' id='"+jsonObj2.uid+"Div'>"+
							"<p class='name2'>"+jsonObj2.name+"</p>	"+
							"<p class='address'>"+jsonObj2.address+"</p>"+
							"<p class='phoneNumber'>15322108638</p>"+
						"</div>"
					);
					
					//之后为我卖出去的订单添加事件
					$(".userImg").mouseover(function(){
						var id="#"+$(this).parent().parent().parent().attr("class")+"Div";
						$(id).show();
						var offset = $(this).offset()
						$(id).css("top",offset.top);
						$(id).css("left",offset.left+$(this).width());
					})
					
					$(".userImg").mouseout(function(){
						$(".userDetailDiv").hide();
					})
				});
			});
		});
	}
	else{
		window.location.replace("login.jsp");
	}
})