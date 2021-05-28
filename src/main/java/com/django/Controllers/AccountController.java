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
            // TB pour la gestion d'erreur si l'utilisateur ne peut être récupéré.	
            // Pour faciliter la lisibilité des logs en cas d'erreur, il peut être plus simple de récupérer
	    // une exception ou un objet représentant une erreur dans le service ServiceUser, et de logger ici l'erreur
	    // récupérée et le message métier.
	    // Par exemple, le même message d'erreur sera retourné ici si l'appelant du programme (UI, client externe, ...) ne fournit
	    // pas de paramètre 'code', ou si le service échoue à retourner un utilisateur alors qu'un code a été fourni.
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
            // 1. D'une manière générale (sauf exception, par exemple avant envoi du résultat final au client),
            // ne JAMAIS faire de bloc catch sur "Exception".
            // En Java, les Exception sont fortement typées et le catch permet de récupérer seulement celles
            // qui nous intéressent. Cela permet de changer le comportement métier / technique en fonction des
            // erreurs reçues.
            // 2. Il existe 2 types d'Exception en Java :
            //    - les "Checked Exception" qui représentent généralement des erreurs en dehors du programme
            //      (I/O sur un fichier, requête SQL ou HTTP invalide, ...). Ces exceptions sont décrites explicitement
            //      dans le protocole des méthodes qui les lèvent, et doivent être traîtées explicitement par les appelants
            //    - les "Unchecked Exception" (héritées de RuntimeException) sont des exceptions généralement liées au
            //      programme lui-même (NullPointerException, IllegalArgumentException, ...). Ces exceptions ne sont pas
            //      toujours décrites dans le protocole de la méthode qui les lévent, et certaines sont générées par le
            //      langage lui-même.
            // On évitera globalement toujours de masquer une exception, sauf lors du passage d'une couche technique à
            // une autre (par exemple, de Backend au Frontend ici) où il peut en effet être PARFOIS utile de masquer des
            // exceptions pour éviter de polluer les couches supérieures. Dans ce cas, il est préférable de masquer le
            // minimum d'exceptions pour éviter d'englober dans la logique actuelle un comportement d'une future exception
            // qui n'existe pas encore dans la couche inférieure et dont le traitement devrait être différent.
            // Ici, la méthode ServiceUser.createUser() ne décrit pas de "Checked Exception", on pourrait donc par exemple masquer
            // uniquement les RuntimeException

            // Code de dev uniquement -> en production, on utilisera toujours un logger (sinon la trace est perdue !)
            e.printStackTrace();

            ModelAndView model = new ModelAndView("signinView", "user", new User());
            model.addObject("errorString", e); //Attention - présenter une exception interne à l'utilisateur final est discutable. Cela peut être une bonne idée, mais peut également polluer l'expérience utilisateur et présenter des risques de sécurité.
            return model; //TB pour la gestion d'une vue d'erreur
        }
    }

        /**
     * Add user and redirect
     * @param user form object user
     * @return ModelAndView
     */
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public ModelAndView checkUser(String login, String password) {
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
        catch(Exception e){ // même remarque sur les exceptions
            e.printStackTrace();
            ModelAndView model = new ModelAndView("loginView", "user", new User());
            model.addObject("errorString", e);
            return model;
        }
    }

    //#endregion
}
