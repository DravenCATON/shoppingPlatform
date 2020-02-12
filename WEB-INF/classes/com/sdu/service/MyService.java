package com.sdu.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sdu.dao.OrderDao;
import com.sdu.dao.ProductDao;
import com.sdu.entity.Order;
import com.sdu.entity.Product;
import com.sdu.entity.ShoppingCar;
import com.sdu.entity.User;

@Transactional
public class MyService
{
	private com.sdu.dao.UserDao userDao;
	private ProductDao productDao;
	private com.sdu.dao.ShoppingCarDao shoppingCarDao;
	private OrderDao orderDao;
	
	public void register(User user) {
		userDao.register(user);
		user.setUid(userDao.getId(user.getUsername()));
	}
	
	public com.sdu.dao.UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(com.sdu.dao.UserDao userDao) {
		this.userDao = userDao;
	}
	public void updateUser(User user) {
		User user2=userDao.getUserById(user.getUid());
		user2.setName(user.getName());
		user2.setSex(user.getSex());
		user2.setAddress(user.getAddress());
		userDao.updateUser(user2);
	}
	public boolean login(User user) {
		User user2=userDao.getUserByUsername(user.getUsername());
		if(user2.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	public boolean changePassword(User user, String newPassword) {
		User user2=userDao.getUserByUsername(user.getUsername());
		if(user2.getPassword().equals(user.getPassword())) {
			user2.setPassword(newPassword);
			userDao.updateUser(user2);
			return true;
		}
		return false;
	}
	public User getUserByUsername(String username) {
		User user =userDao.getUserByUsername(username);
		return user;
	}
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public int addProductAndReturnID(Product product, int userId) {
		User user = userDao.getUserById(userId);
		product.setUser(user);
		productDao.addProduct(product);
		return productDao.getId(product.getName());
	}
	public List<Product> searchProduct(String searchText) {
		return productDao.searchProduct(searchText);
	}
	public Product getProductById(int id) {
		Product product =productDao.getProductById(id);
		return product;
	}
	public com.sdu.dao.ShoppingCarDao getShoppingCarDao() {
		return shoppingCarDao;
	}
	public void setShoppingCarDao(com.sdu.dao.ShoppingCarDao shoppingCarDao) {
		this.shoppingCarDao = shoppingCarDao;
	}
	public void addToShoppingCar(ShoppingCar shoppingCar, int userId, int productId) {
		ShoppingCar shoppingCar2=shoppingCarDao.getShoppingCar(userId,productId);
		if(shoppingCar2==null) {
			User user = userDao.getUserById(userId);
			Product product = productDao.getProductById(productId);
			shoppingCar.setUser(user);
			shoppingCar.setProduct(product);
			shoppingCarDao.addShoppingCar(shoppingCar);
		}else {
			shoppingCar2.setProductNumber(shoppingCar2.getProductNumber()+shoppingCar.getProductNumber());
			shoppingCarDao.update(shoppingCar2);
		}
	}
	public void changeNumber(ShoppingCar shoppingCar, int userId, int productId) {
		ShoppingCar shoppingCar2=shoppingCarDao.getShoppingCar(userId,productId);
		shoppingCar2.setProductNumber(shoppingCar.getProductNumber());
		shoppingCarDao.update(shoppingCar2);
	}
	
	public void deleteShoppingCar(int userId, int productId) {
		ShoppingCar shoppingCar=shoppingCarDao.getShoppingCar(userId,productId);
		shoppingCarDao.delete(shoppingCar);
	}
	
	public void clearShoppingCar(Order order, int userId) {
		List<ShoppingCar> listShoppingCars = shoppingCarDao.findShoppingCarsBySserId(userId);
		User user=userDao.getUserById(userId);
		for (ShoppingCar shoppingCar : listShoppingCars) {
			Order orderTemp=new Order();
			orderTemp.setTime(new java.util.Date());
			orderTemp.setNumber(shoppingCar.getProductNumber());
			orderTemp.setAddress(order.getAddress());
			orderTemp.setProduct(shoppingCar.getProduct());
			orderTemp.setUser(user);
			orderTemp.setUserSaler(shoppingCar.getProduct().getUser());
			orderTemp.setReceived(false);
			orderDao.saveOrder(orderTemp);
			shoppingCarDao.delete(shoppingCar);
		}
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public User getUserByOrderId(int orderId) {
		Order order=orderDao.getOrderById(orderId);
		return order.getUser();
	}
	public void orderReceived(int orderId) {
		Order order=orderDao.getOrderById(orderId);
		order.setReceived(true);
		orderDao.updateOrder(order);
	}
}
