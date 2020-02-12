package com.sdu.action;

import com.sdu.entity.User;
import com.sdu.service.MyService;
import com.sdu.utils.JsonUtil;

@SuppressWarnings("serial")
public class GetUserAction extends com.opensymphony.xwork2.ActionSupport
{
	private String username;
	private User user;
	private String userString;
	private MyService myService;
	
	public String getUser() {
		user=myService.getUserByUsername(username);
		setUserString(JsonUtil.getJsonString4JavaPOJO(user,new String[] {"user","userSaler","setOrder2"}));
		return "getUser";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserString() {
		return userString;
	}

	public void setUserString(String userString) {
		this.userString = userString;
	}



}
