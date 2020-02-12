package com.sdu.action;

import com.sdu.entity.User;
import com.sdu.service.MyService;
import com.sdu.utils.JsonUtil;

@SuppressWarnings("serial")
public class getUserByOrderIdAction extends com.opensymphony.xwork2.ActionSupport{
	private User user = new com.sdu.entity.User();
	private String userString;
	private String orderId; 
	private MyService myService;
	
	
	public String getUserByOrderId() {
		User user2=myService.getUserByOrderId(Integer.parseInt(orderId));
		user.setUid(user2.getUid());
		user.setName(user2.getName());
		user.setAddress(user2.getAddress());
		setUserString(JsonUtil.getJsonString4JavaPOJO(user,new String[] {"user","userSaler","setOrder2"}));
		return "getUserByOrderId";
	}
	public User getUser() {
		return user;
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


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public MyService getMyService() {
		return myService;
	}


	public void setMyService(MyService myService) {
		this.myService = myService;
	}


	
}
