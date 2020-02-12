package com.sdu.action;

@SuppressWarnings("serial")
public class showProductAction extends com.opensymphony.xwork2.ActionSupport
{	
	private String id;
	private com.sdu.service.MyService myService;
	private com.sdu.entity.Product product;
	public String showProduct() {
		product = myService.getProductById(Integer.parseInt(id));
		return "showProduct";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public com.sdu.service.MyService getMyService() {
		return myService;
	}
	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}
	public com.sdu.entity.Product getProduct() {
		return product;
	}
	public void setProduct(com.sdu.entity.Product product) {
		this.product = product;
	}
}
