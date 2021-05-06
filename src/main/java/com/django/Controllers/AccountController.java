package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.django.Configuration.AddUserTR;
import com.django.Models.Roles;
import com.django.Models.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    /**
     * Show login view
     * @return ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        System.out.println("controller login");
        return new ModelAndView("loginView", "user", new User()) ;
    }

    /**
     * Show User info
     * @param error error
     * @param model model
     * @return view and user model
     */
    @RequestMapping({"/userInfo"})
    public String showUser(@RequestParam(value = "code", defaultValue = "", required = true) Integer code, Model model) {
        System.out.println("controller view user info");
        User user = null;
        if(code != null){
            AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            user = myApplicationContext.getBean(AddUserTR.class).getUserById(code);
            myApplicationContext.close();
        }

        if(user != null){
            model.addAttribute("user", user);
        } else{
            model.addAttribute("errorString", "Fail to retrieve user info");
        }
        return "myAccountView";
    }

    /**
     * Add user and redirect
     * @param user form object user
     * @return ModelAndView
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView editUser(String firstName, String lastName, String login, String password) {
        System.out.println("controller add user");
        try{
            if(checkValidString(new String[]{firstName, lastName, login, password})){
                AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
                myApplicationContext.getBean(AddUserTR.class).saveUser(new User(firstName, lastName, login, password, "salt", Roles.client));
                myApplicationContext.close();
            }
            else{
                ModelAndView model = new ModelAndView("loginView", "user", new User());
                model.addObject("errorString", "Input can not be whitespace, empty or null. Please try again.");
                return model;
            }
            return new ModelAndView("homeView");
        }
        catch(Exception e){
            e.printStackTrace();
            ModelAndView model = new ModelAndView("loginView", "user", new User());
            model.addObject("errorString", e);
            return model;
        }
    }

    /**
     * Validate form inputs
     * @param texts inputs
     * @return boolean
     */
    private Boolean checkValidString(String[] texts){
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
    private Boolean notWhiteSpaceEmptyOrNull(String text){
        return (text !=null && !text.isEmpty() && !text.trim().isEmpty());
    }
}
