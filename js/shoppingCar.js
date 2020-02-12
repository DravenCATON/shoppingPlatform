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
	
	
	/*新版本的jquery对于那些无值属性，用prop设置，且在jquery中用true表示有这个属性，用false表示没有这个属性*/
	
	$("#allCheckbox").change(function(){
		if($(this).prop("checked")){
			$("[type='checkbox']").prop("checked",true);
		}
	})
	
	var username=$.cookie("username");
	if(username!="null"){
		$.post("getUser",{'username':username},function(data){
			var jsonObj = JSON.parse(data);
			$("#headImage").attr("src","img/headImage/header"+jsonObj.uid+".jpg")
			$("#pName").text("姓名："+jsonObj.name);
			$("#pSex").text("性别："+jsonObj.sex);
			$("#pAddress").text("地址："+jsonObj.address);
			
			$.each(jsonObj.setShoppingCar,function(index,value){
				var wholePrice = value.product.price*value.productNumber;
				$("table").prepend(  
						"<tr>"+
						"<td class='selected'><input name='"+value.product.pid+"' type='checkbox' checked/></td>"+
						"<td class='content'>"+
							"<img class='product' src='img/product/product"+value.product.pid+".png'>"+
							"<p class='description'><a href='showProduct.action?id="+value.product.pid+"' class='descriptionA'>"+value.product.name+"</a></p>"+
						"</td>"+
						"<td class='price'>￥"+value.product.price+"</td>"+
						"<td class='count'><input type='number' name='1' min='1' value='"+value.productNumber+"' class='counter'/></td>"+
						"<td class='wholePrice'>￥"+wholePrice+"</td>"+
						"<td class='delete'>"+
						"<a class='deleteA' href=''>删除</a>"+
						"</td>"+
						"</tr>");
			})
			
			$("[type='number']").change(function(){
				var singleValue=$(this).parent().siblings(".price").text().slice(1);
				var p=$(this).val();
				var pid=$(this).parent().siblings(".selected").children("input").attr("name");
				var value=singleValue * p;
				value=value.toFixed(2);
				var counter=$(this);
				$.post("changeNumber",{'count':p,'pid':pid,'uid':jsonObj.uid},function(data){
					counter.parent().siblings(".wholePrice").text("￥"+value);
				});
			})
			
			$(".deleteA").click(function(event){
				event.preventDefault();
				var pid=$(this).parent().siblings(".selected").children("input").attr("name");
				var deleteButton=$(this);
				$.post("deleteShoppingCar",{'pid':pid,'uid':jsonObj.uid},function(data){
					deleteButton.parent().parent().remove();
				});
			})
			
			$("#clearShoppingCarButton").click(function(){
				$("#identify").show();
				$("#opacityLevel").show();
				$("#yes").click(function(){
					$.post("clearShoppingCar",{'userId':jsonObj.uid,'address':jsonObj.address},function(data){
						$("#identify").hide();
						$("#opacityLevel").hide();
						$("table").remove();
						alert("已清空购物车");
					});
				})
				$("#no").click(function(){
				$("#identify").hide();
				$("#opacityLevel").hide();
		})
	})
		});
	}
	else{
		window.location.replace("login.jsp");
	}
	
	
})