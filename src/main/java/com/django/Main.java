package com.django;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {


	public static void main(String[] args) {
		ApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("com.django");
		System.out.println("Hello World!");
		System.out.println(myApplicationContext.getApplicationName());
		System.out.println(myApplicationContext.getBean(Main.class));
		return;
	}

}