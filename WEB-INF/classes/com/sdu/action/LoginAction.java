package com.sdu.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sdu.entity.User;
import com.sdu.service.MyService;

@SuppressWarnings("serial")
public class LoginAction extends com.opensymphony.xwork2.ActionSupport implements com.opensymphony.xwork2.ModelDriven<User>
{
	private MyService myService;
	private User user=new User();
	public String login() throws UnsupportedEncodingException {
		boolean isSuccess=myService.login(user);
		if(isSuccess) {
			javax.servlet.http.Cookie cookie=new javax.servlet.http.Cookie("username",URLEncoder.encode(user.getUsername(),"UTF-8"));
			HttpServletResponse response = ServletActionContext.getResponse();
			cookie.setMaxAge(3600);
			//设置路径，这个路径即该工程下都可以访问该cookie如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
			cookie.setPath("/");
			response.addCookie(cookie);
			return SUCCESS;
		}
		return ERROR;
	}
	
	@Override
	public User getModel() {
		return user;
	}
	
	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
