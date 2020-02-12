package com.sdu.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.sdu.entity.Order;
import com.sdu.entity.User;

public class OrderDao 
{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void saveOrder(Order orderTemp) {
		hibernateTemplate.save(orderTemp);
	}

	public Order getOrderById(int orderId) {
		List<Order> order = (List<Order>) hibernateTemplate.find("from Order where oid=?",orderId);
		return order.get(0);
	}

	public void updateOrder(Order order) {
		hibernateTemplate.update(order);
	}
}
