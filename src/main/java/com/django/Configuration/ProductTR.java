package com.django.Configuration;


import com.django.Models.Product;

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

	public void saveUser(Product product) {
		Session session = sessionFactory.getCurrentSession();
        session.save(product);
	}

    //get all product

    //edit product

    //delete product
}
