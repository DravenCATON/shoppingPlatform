package com.sdu.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sdu.entity.User;
import com.sdu.service.MyService;

@SuppressWarnings("serial")
public class UpdateUserAction extends ActionSupport {
	private MyService myService;
	private User user = new User();
	private int id;
	private String name;
	private File file;
	private String sex;
	private String address;
	public String updateUser() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String rootUrl=request.getServletContext().getRealPath("/");
		if(file!=null) {
			String url=rootUrl+"img\\headImage\\header"+id+".jpg";
			File oldPhtotFile=new File(url);
			oldPhtotFile.delete();
			com.sdu.utils.copyFile.copy(file,url);
		}
		user.setUid(id);
		user.setName(name);
		user.setSex(sex);
		user.setAddress(address);
		myService.updateUser(user);
		return "updateUser";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}

	public com.sdu.entity.User getUser() {
		return user;
	}

	public void setUser(com.sdu.entity.User user) {
		this.user = user;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
