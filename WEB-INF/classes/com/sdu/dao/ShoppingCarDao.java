package com.sdu.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.sdu.entity.ShoppingCar;

public class ShoppingCarDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void addShoppingCar(ShoppingCar shoppingCar) {
		hibernateTemplate.save(shoppingCar);
	}

	public ShoppingCar getShoppingCar(int userId, int productId) {
		List<ShoppingCar> listShoppingCar = (List<ShoppingCar>) hibernateTemplate.find("from ShoppingCar where userId=? and productId=?",userId,productId);
		if(listShoppingCar.size()==0) {
			return null;
		}
		return listShoppingCar.get(0);
	}


	public void update(ShoppingCar shoppingCar2) {
		hibernateTemplate.update(shoppingCar2);
	}

	public void delete(ShoppingCar shoppingCar) {
		hibernateTemplate.delete(shoppingCar);
	}

	public List<ShoppingCar> findShoppingCarsBySserId(int userId) {
		List<ShoppingCar> listShoppingCar = (List<ShoppingCar>) hibernateTemplate.find("from ShoppingCar where userId=?",userId);
		return listShoppingCar;
	}
}
