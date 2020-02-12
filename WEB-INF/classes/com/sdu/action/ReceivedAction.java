package com.sdu.action;

@SuppressWarnings("serial")
public class ReceivedAction extends com.opensymphony.xwork2.ActionSupport
{
	private String orderId;
	private com.sdu.service.MyService myService;
	public String received() {
		myService.orderReceived(Integer.parseInt(orderId));
		return "received";
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public com.sdu.service.MyService getMyService() {
		return myService;
	}
	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}
}
