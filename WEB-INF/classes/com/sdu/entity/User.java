package com.sdu.entity;
import java.util.HashSet;
import java.util.Set;

public class User {
	private int uid;
	private String username;
	private String password;
	private String sex;
	private String name;
	private String address;
	
	private Set<Product> setProduct=new HashSet<Product>();
	private Set<ShoppingCar> setShoppingCar=new HashSet<ShoppingCar>();
	private Set<Order> setOrder=new HashSet<Order>();
	private Set<Order> setOrderSaler=new HashSet<Order>();
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Product> getSetProduct() {
		return setProduct;
	}
	public void setSetProduct(Set<Product> setProduct) {
		this.setProduct = setProduct;
	}
	public Set<ShoppingCar> getSetShoppingCar() {
		return setShoppingCar;
	}
	public void setSetShoppingCar(Set<ShoppingCar> setShoppingCar) {
		this.setShoppingCar = setShoppingCar;
	}
	public Set<Order> getSetOrder() {
		return setOrder;
	}
	public void setSetOrder(Set<Order> setOrder) {
		this.setOrder = setOrder;
	}
	public Set<Order> getSetOrderSaler() {
		return setOrderSaler;
	}
	public void setSetOrderSaler(Set<Order> setOrderSaler) {
		this.setOrderSaler = setOrderSaler;
	}
	

}
