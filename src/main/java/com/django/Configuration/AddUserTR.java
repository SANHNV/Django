package com.django.Configuration;
import com.django.Models.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AddUserTR {
    
	@Autowired
	private SessionFactory sessionFactory;

    public User getUserById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("select d from User d where d.id = :id", User.class).setParameter("id", id).getSingleResult();
	}

	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
        session.save(user);
	}
}
