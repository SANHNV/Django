package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.django.Configuration.AddUserTR;
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
    public String showUser(@RequestParam(value = "error", defaultValue = "", required = true) String error, Model model) {
        System.out.println("controller view user info");
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
        System.out.println(firstName);
        try{
            System.out.println("first name user : ");
            // if(user.idUser() == null){
            //     AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
            //     myApplicationContext.getBean(AddUserTR.class).saveUser(user);
            //     myApplicationContext.close();
            // }
            return new ModelAndView("homeView");
        }
        catch(Exception e){
            e.printStackTrace();
            ModelAndView model = new ModelAndView("loginView", "user", new User());
            model.addObject("errorString", e);
            return model;
        }
    }
}
