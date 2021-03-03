package com.django;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("com.django");
		System.out.println("Hello World!");
		System.out.println(myApplicationContext);
		return;
	}

}