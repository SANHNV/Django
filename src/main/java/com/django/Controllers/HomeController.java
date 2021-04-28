package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    
    @RequestMapping({"/", "/hello"})
    public String hola(@RequestParam(value = "name", defaultValue = "World", required = true) String name, Model model) {
        System.out.println("controller hello");
        model.addAttribute("name", name);
        return "hello";
    }

    // @RequestMapping("/")
	// public ModelAndView home(ModelAndView modelAndView) {
		
	// 	modelAndView.setViewName("home");
	// 	modelAndView.getModel().put("name", "John");
    //     System.out.println("controller hello");
	// 	return modelAndView;
	// }
}
