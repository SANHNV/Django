package com.django.Configuration;


import java.util.List;

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

    /**
     * Get Product by ID
     * @param id code product
     * @return product
     */
    public Product getProductById(Integer id) {
		Product p = new Product();
		try {
			p = sessionFactory.getCurrentSession().createQuery("select d from Product d where d.id = :id", Product.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			p = null;
		}
		return p;
	}

    /**
     * Get All Products 
     * @return list of products
     */
	public List<Product> getProducts(){
		return sessionFactory.getCurrentSession().createNativeQuery("select * from Product", Product.class).getResultList();
	}

    /**
     * Save new Product
     * @param product Product
     * @return product saved
     */
	public Product saveProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
        session.save(product);
		return product;
	}

	/**
     * Save the changed Product
     * @param product _p
     */
	public void editProduct(Product _p){
		Product p = getProductById(_p.getIdProduct());
		Session session = sessionFactory.getCurrentSession();
		if(p == null){
			saveProduct(_p);
		}
		else{
			session.evict(p);
			session.update(_p);
		}
	}

	/**
     * Delete a product with it's id
     * @param int id
     */
	public void deleteProduct(int id){
		Product p = getProductById(id);
		Session session = sessionFactory.getCurrentSession();
		session.delete(p);
		session.flush();
	}
}
