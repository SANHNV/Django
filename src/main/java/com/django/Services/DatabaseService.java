package com.django.Services;

import java.util.List;

import com.django.Configuration.AddUserTR;
import com.django.Configuration.ProductTR;
import com.django.Models.Product;
import com.django.Models.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DatabaseService {
    
    //#region Products
    /**
     * 
     * @param id
     * @return
     */
    public static Product getSingleProduct(int id){
        Product product = null;
        try {
            AnnotationConfigApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            product = myApplicationContext.getBean(ProductTR.class).getProductById(id);
            myApplicationContext.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return product;
    } 

    /**
     * 
     * @param p
     */
    public static void saveProduct(Product p){
        try {
        AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        myApplicationContext.getBean(ProductTR.class).saveProduct(p);
        myApplicationContext.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param id
     */
    public static void deleteProduct(int id){
        try{
            AnnotationConfigApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            myApplicationContext.getBean(ProductTR.class).deleteProduct(id);
            myApplicationContext.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 
     * @return
     */
    public static List<Product> getProducts(){
        List<Product> products = null;
        try{
            AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            products = myApplicationContext.getBean(ProductTR.class).getProducts();
            myApplicationContext.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    //#endregion

    //#region Users

    /**
     * 
     * @param id
     * @return
     */
    public static User getUserById(int id){
        User user = null;
        try{
            AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            user = myApplicationContext.getBean(AddUserTR.class).getUserById(id);
            myApplicationContext.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 
     * @param user
     * @return
     */
    public static User saveUser(User user){
        try{
            AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            myApplicationContext.getBean(AddUserTR.class).saveUser(user);
            user = getUserByLogin(user.getLogin());
            myApplicationContext.close();
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }

    /**
     * 
     * @param login
     * @return
     */
    public static User getUserByLogin(String login){
        User user = null;
        try{
            AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            user = myApplicationContext.getBean(AddUserTR.class).getUserByLogin(login);
            myApplicationContext.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 
     * @param login
     * @param password
     * @return
     */
    public static String [] getSecrets(String login, String password){
        String [] secret = null;
        try 
        {
            AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            secret = myApplicationContext.getBean(AddUserTR.class).getSaltAndPasswordByLogin(login);
            myApplicationContext.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return secret;
    }

    //#endregion
}
