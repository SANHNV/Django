package com.django.Configuration;


import java.util.ArrayList;
import java.util.List;

import com.django.Models.Product;
import com.mysql.cj.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ProductTR {

    @Autowired
	private SessionFactory sessionFactory;

    public Product getProductById(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("select d from Product d where d.id = :id", Product.class).setParameter("id", id).getSingleResult();
	}

	public List<Product> getProducts(){
		return sessionFactory.getCurrentSession().createNativeQuery("select * from Product", Product.class).getResultList();
	}

	public void saveUser(Product product) {
		Session session = sessionFactory.getCurrentSession();
        session.save(product);
	}
}
