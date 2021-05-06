package com.django.Services;

import java.util.List;

import com.django.Configuration.AddUserTR;
import com.django.Configuration.ProductTR;
import com.django.Models.Product;
import com.django.Models.Roles;
import com.django.Models.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DatabaseService {
    

    //#region Products
    public Product getSingleProduct(int id){
        AnnotationConfigApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        Product product = myApplicationContext.getBean(ProductTR.class).getProductById(id);
        myApplicationContext.close();
        return product;
    } 

    public void saveProduct(Product p){
        AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        myApplicationContext.getBean(ProductTR.class).saveProduct(p);
        myApplicationContext.close();
    }

    public void deleteProduct(int id){
        AnnotationConfigApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        myApplicationContext.getBean(ProductTR.class).deleteProduct(id);
        myApplicationContext.close();
    }

    public List<Product> getProducts(){
        AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        List<Product> products = myApplicationContext.getBean(ProductTR.class).getProducts();
        myApplicationContext.close();
        return products;
    }
    //#endregion

    //#region Users

    public User getUserById(int id){
        AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        User user = myApplicationContext.getBean(AddUserTR.class).getUserById(id);
        myApplicationContext.close();
        return user;
    }

    public void saveUser(String firstName, String lastName, String login, String password){
        AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        myApplicationContext.getBean(AddUserTR.class).saveUser(new User(firstName, lastName, login, password, "salt", Roles.client));
        myApplicationContext.close();
    }

    //#endregion
}
