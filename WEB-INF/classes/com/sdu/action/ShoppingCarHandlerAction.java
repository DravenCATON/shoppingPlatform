package com.sdu.action;

import com.sdu.entity.ShoppingCar;

@SuppressWarnings("serial")
public class ShoppingCarHandlerAction extends com.opensymphony.xwork2.ActionSupport
{
	private String count;
	private String pid;
	private String uid;
	private ShoppingCar shoppingCar=new ShoppingCar();
	private com.sdu.service.MyService mService;
	
	public String changeNumber() {
		shoppingCar.setProductNumber(Integer.parseInt(count));
		myService.changeNumber(shoppingCar,Integer.parseInt(uid),Integer.parseInt(pid));
		return "changeNumber";
	}
	
	public String deleteShoppingCar() {
		myService.deleteShoppingCar(Integer.parseInt(uid),Integer.parseInt(pid));
		return "deleteShoppingCar";
	}
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public com.sdu.service.MyService getMyService() {
		return myService;
	}
	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}
	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}

	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}
	public com.sdu.service.MyService getmService() {
		return mService;
	}

	public void setmService(com.sdu.service.MyService mService) {
		this.mService = mService;
	}
	private com.sdu.service.MyService myService;
}
