package com.sdu.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class SendProductAction extends com.opensymphony.xwork2.ActionSupport
{
	private File productImage;
	private int userId;
	private String name;
	private String price;
	private com.sdu.entity.Product product=new com.sdu.entity.Product();
	private com.sdu.service.MyService myService;

	public String sendProduct() throws Exception {
		product.setName(name);
		product.setPrice(Double.parseDouble(price));
		int id=myService.addProductAndReturnID(product,userId);
		HttpServletRequest request = ServletActionContext.getRequest();
		String rootUrl=request.getServletContext().getRealPath("/");
		String url=rootUrl+"img\\product\\product"+id+".png";
		com.sdu.utils.copyFile.copy(productImage,url);
		return "sendProduct";
	}
	
	public com.sdu.service.MyService getMyService() {
		return myService;
	}

	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}

	public File getProductImage() {
		return productImage;
	}

	public void setProductImage(File productImage) {
		this.productImage = productImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public com.sdu.entity.Product getProduct() {
		return product;
	}

	public void setProduct(com.sdu.entity.Product product) {
		this.product = product;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
