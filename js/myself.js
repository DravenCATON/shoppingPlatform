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
	
	$("#backToLogin").click(function(){
		$.removeCookie('username',{ path: '/'});
		window.location.replace("login.jsp");
	})
	
	$("#headImage").mouseover(function(){
		$("#userInformation").slideDown(200);
	})
	
	$("#headImage").mouseout(function(){
		$("#userInformation").slideUp(200);
	})
	
	$("#boyImg").click(function(){
		$(this).css("border-color","#CCC").css("border-style","solid").css("border-width","1px");
		$("#boyRadio").prop("checked",true);
		$("#grilImg").css("border-width","0");
	})
	$("#grilImg").click(function(){
		$(this).css("border-color","#CCC").css("border-style","solid").css("border-width","1px");
		$("#grilRadio").prop("checked",true);
		$("#boyImg").css("border-width","0");
	})
	
	var username=$.cookie("username");
	if(username!="null"){
		$.post("getUser",{'username':username},function(data){
			var jsonObj = JSON.parse(data);
			$("#headImage").attr("src","img/headImage/header"+jsonObj.uid+".jpg")
			$("#photo").attr("src","img/headImage/header"+jsonObj.uid+".jpg")
			$("#pName").text("姓名："+jsonObj.name);
			$("#pSex").text("性别："+jsonObj.sex);
			$("#pAddress").text("地址："+jsonObj.address);
			$("#id").val(jsonObj.uid);
			$("#name").val(jsonObj.name);
			if(jsonObj.sex=="男"){
				$("#boyImg").click();
			}
			if(jsonObj.sex=="女"){
				$("#grilImg").click();
			}
			$("#address").text(jsonObj.address);
		});
	}
	else{
		/*window.location.replace("login.jsp");*/
	}
	
	
	//文件未上传回显
	var uploadInput = $(".uploadInput");
	var photoContainer = $("#photoContainer");
	var photo=$("#photo");
	var uploadTip=$("#uploadTip");
	function checkFile(file){
		var fileSize = file[0].size; //容量检测
	    if(fileSize > 10*1024*1024){
	    	uploadTip.text("上传的文件不大于10M");
	        return false;
	    }
	    var fileName = file[0].name;
	    if(fileName.lastIndexOf('.') == -1){//后缀检测
	    	uploadTip.text("后缀名错误");
	        return false;
	    }
	    var suffix = fileName.substr(fileName.lastIndexOf('.') + 1, fileName.length );
	    var suffixReg = /^jpg|jpeg|png|JPG|JPEG|PNG$/;
	    if (!suffixReg.test(suffix)) {
	    	uploadTip.text("图片类型必须是jpg,jpeg,png中的一种");
	        return false;
	    }
	    return true;
	}
	
	function getObjectURL(file) {
	    var url = null ;
	    if (window.createObjectURL!=undefined) { // basic
	        url = window.createObjectURL(file) ;
	    } else if (window.URL!=undefined) { // mozilla(firefox)
	        url = window.URL.createObjectURL(file) ;
	    } else if (window.webkitURL!=undefined) { // webkit or chrome
	        url = window.webkitURL.createObjectURL(file) ;
	    }
	    return url ;
	}
	
	uploadInput.change(function(){
		var files = this.files;
	    if(!checkFile(files)){
	        $(this).val("");
	        return;
	    }
	    var url2=getObjectURL(files[0]);
	    photo.attr("src", url2);
	    photo.css("max-width","478px");
	    photo.css("max-height","478px");
	    uploadTip.text("");
	});
	
	
})