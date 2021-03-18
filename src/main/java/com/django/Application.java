package com.django;

import com.django.Configuration.AddUserTR;
import com.django.Models.Roles;
import com.django.Models.User;
import com.django.test.Test;

import org.hibernate.HibernateException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);

		System.out.println("Hello World!");

		//Test Injection of Dependence
		AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
		System.out.println(myApplicationContext.getBean(Test.class).test());
		try{
			//Test Hibernate
			User user = new User(3, "test10", "test10", "test101", "test10", "test10", Roles.adminGlobal);
			System.out.println(myApplicationContext.getBean(AddUserTR.class).getUserById(1).getFirstName());

			myApplicationContext.getBean(AddUserTR.class).saveUser(user);
        } catch(HibernateException e) {
            e.printStackTrace();
        }
		myApplicationContext.close();

		return;
	}

}