package com.sdu.action;

import java.util.List;

import com.sdu.entity.Product;

@SuppressWarnings("serial")
public class searchAction extends com.opensymphony.xwork2.ActionSupport
{
	private String searchText;
	private com.sdu.service.MyService myService;
	private List<Product> listProduct;
	public String searchProduct() {
		System.out.println(searchText);
		setListProduct(myService.searchProduct(searchText));
		return "searchProduct";
	}
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public com.sdu.service.MyService getMyService() {
		return myService;
	}
	public void setMyService(com.sdu.service.MyService myService) {
		this.myService = myService;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
}
