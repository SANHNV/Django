package com.django.Services;

import com.django.Models.Roles;
import com.django.Models.User;

public class ServiceUser {
    
    /**
     * Get User by Id or null
     * @param id id user
     * @return user
     */
    public static User getUserById(Integer id){
        return DatabaseService.getUserById(id);
    }

    /**
     * Get User by Login or null
     * @param login login user
     * @return user
     */
    public static User getUserByLogin(String login){
        return DatabaseService.getUserByLogin(login);
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
                byte[] hashPassword = ServiceSecure.hash(password.toCharArray(), salt);

                user = new User(firstName, lastName, login, new String(hashPassword), new String(salt), Roles.client);
                user = DatabaseService.saveUser(user);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            user = null;
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
        try {
            if(checkValidString(new String[]{login, password})){
                String [] secret = DatabaseService.getSecrets(login, password);
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
