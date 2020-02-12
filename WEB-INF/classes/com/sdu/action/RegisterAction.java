package com.sdu.action;


import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sdu.entity.User;
import com.sdu.service.MyService;
import com.sdu.utils.copyFile;;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport implements com.opensymphony.xwork2.ModelDriven<User>
{
	private MyService myService;
	private User user=new User();
	
	public String register() throws Exception{
		myService.register(user);
		javax.servlet.http.Cookie cookie=new javax.servlet.http.Cookie("username",URLEncoder.encode(user.getUsername(),"UTF-8"));
		HttpServletResponse response = ServletActionContext.getResponse();
		cookie.setMaxAge(3600);
		//设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
		cookie.setPath("/");
		response.addCookie(cookie);
		HttpServletRequest request = ServletActionContext.getRequest();
		String rootUrl=request.getServletContext().getRealPath("/");
		String url1=rootUrl+"img\\headImage\\header.png";
		String url2=rootUrl+"img\\headImage\\header"+user.getUid()+".jpg";
		copyFile.copy(url1,url2);
		return "register";
	}

	public com.sdu.entity.User getUser() {
		return user;
	}
	public void setUser(com.sdu.entity.User user) {
		this.user = user;
	}
	public MyService getMyService() {
		return myService;
	}
	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	
}
