package com.sdu.entity;

import javax.persistence.Column;

public class Order {
	private int oid;
	private java.util.Date time;
	private String address;
	private int number;
	private boolean received=false;
	
	private Product product;
	private User user;
	private User userSaler;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public java.util.Date getTime() {
		return time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUserSaler() {
		return userSaler;
	}
	public void setUserSaler(User userSaler) {
		this.userSaler = userSaler;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public boolean isReceived() {
		return received;
	}
	public void setReceived(boolean received) {
		this.received = received;
	}

}
