package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.django.Models.User;
import com.django.Services.ServiceUser;

import org.springframework.stereotype.Controller;

@Controller
public class AccountController {


    //#region GET

    /**
     * Show login view
     * @return ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        return new ModelAndView("loginView", "user", new User()) ;
    }

    /**
     * Show signin view
     * @return ModelAndView
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView showSignin() {
        return new ModelAndView("signinView", "user", new User()) ;
    }

    /**
     * Show User info
     * @param error error
     * @param model model
     * @return view and user model
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String showUser(@RequestParam(value = "code", defaultValue = "", required = true) Integer code, Model model) {
        
        //Get User
        User user = code != null ? ServiceUser.getUserById(code) : null;

        //Add user or error message
        if(user != null){
            model.addAttribute("user", user);
        } else{
            model.addAttribute("errorString", "Fail to retrieve user info");
        }
        return "myAccountView";
    }

    //#endregion

    //#region POST

    /**
     * Add user and redirect
     * @param user form object user
     * @return ModelAndView
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView editUser(String firstName, String lastName, String login, String password) {
        System.out.println("controller add user");
        try{
            User user = ServiceUser.createUser(firstName, lastName, login, password);
            if(user != null){
                return new ModelAndView("homeView", "user", user);
            }
            else{
                ModelAndView model = new ModelAndView("signinView", "user", new User());
                model.addObject("errorString", "Input can not be whitespace, empty or null. Please try again.");
                return model;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            ModelAndView model = new ModelAndView("signinView", "user", new User());
            model.addObject("errorString", e);
            return model;
        }
    }

        /**
     * Add user and redirect
     * @param user form object user
     * @return ModelAndView
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public ModelAndView checkUser(String login, String password) {
        System.out.println("controller add user");
        try{
            if(ServiceUser.checkUser(login, password)){
                User user = ServiceUser.getUserByLogin(login);
                return new ModelAndView("homeView", "user", user);
            }
            else{
                ModelAndView model = new ModelAndView("loginView", "user", new User());
                model.addObject("errorString", "Wrong password or login. Please try again.");
                return model;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            ModelAndView model = new ModelAndView("loginView", "user", new User());
            model.addObject("errorString", e);
            return model;
        }
    }

    //#endregion
}
