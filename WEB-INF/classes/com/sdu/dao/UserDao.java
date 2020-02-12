package com.sdu.dao;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.sdu.entity.User;

public class UserDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void register(User user) {
		hibernateTemplate.save(user);
	}

	public int getId(String username) {
		List<Integer> id = (List<Integer>) hibernateTemplate.find("select uid from User where username=?",username);
		if(id.size()==0) {
			return 0;
		}
		return id.get(0);
	}

	public User getUserByUsername(String username) {
		List<User> user = (List<User>) hibernateTemplate.find("from User where username=?",username);
		if(user.size()==0) {
			return null;
		}
		return user.get(0);
	}
	
	public User getUserById(int id) {
		List<User> user = (List<User>) hibernateTemplate.find("from User where uid=?",id);
		if(user.size()==0) {
			return null;
		}
		return user.get(0);
	}

	public void updateUser(User user) {
		hibernateTemplate.update(user);
	}
}
