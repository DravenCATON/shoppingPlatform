package com.sdu.entity;
import java.util.HashSet;
import java.util.Set;

public class Product {
	private int pid;
	private String name;
	private double price;
	
	private User user;//指的是发布商品的那位用户
	private Set<Order> setOrder2=new HashSet<Order>();
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Order> getSetOrder2() {
		return setOrder2;
	}
	public void setSetOrder2(Set<Order> setOrder2) {
		this.setOrder2 = setOrder2;
	}
}
