package com.django;

import com.django.Models.Roles;
import com.django.Models.User;
import com.django.test.Test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
		System.out.println("Hello World!");
		System.out.println(myApplicationContext.getBean(Test.class).test());
		myApplicationContext.close();
		User user = new User(1, "firstName", "lastName", "login", "password", "salt", Roles.adminGlobal);
		try {
            SessionFactory sessionFactory = new Configuration().configure("/com/django/hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } catch(HibernateException e) {
            e.printStackTrace();
        }

		return;
	}

}