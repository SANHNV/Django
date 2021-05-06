package com.django.Services;

import com.django.Models.Roles;
import com.django.Models.User;
import com.django.Configuration.AddUserTR;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServiceUser {
    
    /**
     * Get User by Id or null
     * @param id id user
     * @return user
     */
    public static User getUserById(Integer id){
        User user = null;
        try{
            AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            user = myApplicationContext.getBean(AddUserTR.class).getUserById(id);
            myApplicationContext.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

        /**
     * Get User by Login or null
     * @param login login user
     * @return user
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
     * Create User
     * @param firstName
     * @param lastName
     * @param login
     * @param password
     * @return User created or
     */
    public static User createUser(String firstName, String lastName, String login, String password){
        User user = null;
        try{
            if(checkValidString(new String[]{firstName, lastName, login, password})){
                byte[] salt = ServiceSecure.getNextSalt();
                System.out.println("salt = " + new String(salt));
                byte[] hashPassword = ServiceSecure.hash(password.toCharArray(), salt);
                System.out.println("password = " + new String(hashPassword));

                user = new User(firstName, lastName, login, new String(hashPassword), new String(salt), Roles.client);
                AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
                myApplicationContext.getBean(AddUserTR.class).saveUser(user);
                user = myApplicationContext.getBean(AddUserTR.class).getUserByLogin(login);
                myApplicationContext.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Check User
     * @param login
     * @param password
     * @return boolean
     */
    public static Boolean checkUser(String login, String password){
        try{
            if(checkValidString(new String[]{login, password})){
                AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
                String [] secret = myApplicationContext.getBean(AddUserTR.class).getSaltAndPasswordByLogin(login);
                myApplicationContext.close();
                return ServiceSecure.isExpectedPassword(password.toCharArray(), secret[1].getBytes(), secret[0].getBytes());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    //#region Private Properties

    /**
     * Validate form inputs
     * @param texts inputs
     * @return boolean
     */
    private static Boolean checkValidString(String[] texts){
        for (String text : texts) {
            if(!notWhiteSpaceEmptyOrNull(text)){return false;}
        }
        return true;
    }

    /**
     * Check text not WhiteSpace, Empty or Null
     * @param text string
     * @return boolean
     */
    private static Boolean notWhiteSpaceEmptyOrNull(String text){
        return (text !=null && !text.isEmpty() && !text.trim().isEmpty());
    }

    //#endregion
}
