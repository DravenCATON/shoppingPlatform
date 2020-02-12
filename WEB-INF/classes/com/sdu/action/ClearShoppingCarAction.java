package com.sdu.action;


import com.sdu.entity.Order;

@SuppressWarnings("serial")
public class ClearShoppingCarAction extends com.opensymphony.xwork2.ActionSupport
{
	private String userId;
	private String address;
	private com.sdu.service.MyService myService;
	private Order order=new Order();
	
	public String clearShoppingCar() {
		order.setAddress(address);
		myService.clearShoppingCar(order,Integer.parseInt(userId));
		return "clearShoppingCar";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public com.sdu.service.MyService getMyService() {
		return myService;
	}
	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
