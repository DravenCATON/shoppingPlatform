package com.sdu.action;

import com.sdu.entity.ShoppingCar;

@SuppressWarnings("serial")
public class AddToShoppingCarAction extends com.opensymphony.xwork2.ActionSupport
{
	private com.sdu.service.MyService myService;
	private String count;
	private String userId;
	private String productId;
	private ShoppingCar shoppingCar=new ShoppingCar();
	public String addToShoppingCar() {
		shoppingCar.setProductNumber(Integer.parseInt(count));
		myService.addToShoppingCar(shoppingCar,Integer.parseInt(userId),Integer.parseInt(productId));
		return "addToShoppingCar";
	}
	
	public com.sdu.service.MyService getMyService() {
		return myService;
	}
	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public com.sdu.entity.ShoppingCar getShoppingCar() {
		return shoppingCar;
	}
	public void setShoppingCar(com.sdu.entity.ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}

}
