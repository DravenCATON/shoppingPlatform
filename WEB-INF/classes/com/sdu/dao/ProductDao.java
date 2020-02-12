package com.sdu.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.sdu.entity.Product;
import com.sdu.entity.User;

public class ProductDao 
{
	private HibernateTemplate hibernateTemplate;
	
	public void addProduct(Product product) {
		hibernateTemplate.save(product);
	}
	
	public int getId(String name) {
		List<Integer> id = (List<Integer>) hibernateTemplate.find("select pid from Product where name=?",name);
		return id.get(0);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Product> searchProduct(String searchText) {
		List<Product> listProduct = (List<Product>) hibernateTemplate.find("from Product where name like '%"+searchText+"%'");
		return  listProduct;
	}

	public Product getProductById(int id) {
		List<Product> product = (List<Product>) hibernateTemplate.find("from Product where pid=?",id);
		return product.get(0);
	}
	
	
}
