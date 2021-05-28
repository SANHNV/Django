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
     * @return User created or null
     */
    public static User createUser(String firstName, String lastName, String login, String password){
        User user = null;
        try{
            if(checkValidString(new String[]{firstName, lastName, login, password})){
                byte[] salt = ServiceSecure.getNextSalt(); //TB
                byte[] hashPassword = ServiceSecure.hash(password.toCharArray(), salt);

                user = DatabaseService.saveUser(new User(firstName, lastName, login, new String(hashPassword), new String(salt), Roles.client));
            } // else ? il est dommage de masquer les erreurs
        }
        catch(Exception e){ // voir commentaire sur les exceptions dans les contrôleurs
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
        if(checkValidString(new String[]{login, password})){
            String [] secret = DatabaseService.getSecrets(login, password);
            return ServiceSecure.isExpectedPassword(password.toCharArray(), secret[1].getBytes(), secret[0].getBytes());
        }
        return false; //Attention : si cette méthode retourne 'false', comment savoir si le login/mot de passe sont incorrects,
	// ou si l'appelant a mal transmis les paramètres (par exemple, avec un espace restant à la fin du login ou mot de passe) ?
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
