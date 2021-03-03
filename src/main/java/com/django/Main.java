package com.django;

import com.django.test.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
		System.out.println("Hello World!");
		System.out.println(myApplicationContext.getBean(Test.class));
		myApplicationContext.close();
		return;
	}

}