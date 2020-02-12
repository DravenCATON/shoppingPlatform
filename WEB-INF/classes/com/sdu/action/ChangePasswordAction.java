package com.sdu.action;

import com.sdu.entity.User;

@SuppressWarnings("serial")
public class ChangePasswordAction extends com.opensymphony.xwork2.ActionSupport
{
	private String username;
	private String oldPassword;
	private String newPassword;
	private com.sdu.service.MyService myService;
	private User user=new com.sdu.entity.User();
	private String isSuccess;
	
	public String changePassword() {
		user.setUsername(username);
		user.setPassword(oldPassword);
		boolean h = myService.changePassword(user,newPassword);
		if(h) {
			isSuccess="true";
		}else {
			isSuccess="false";
		}
		return "changePassword";
	}
	

	public String getIsSuccess() {
		return isSuccess;
	}


	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public com.sdu.service.MyService getMyService() {
		return myService;
	}

	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}


}
