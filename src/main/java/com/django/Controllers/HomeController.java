package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    
    @RequestMapping({"/", "/hello"})
    public String hola(@RequestParam(value = "name", defaultValue = "World", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "homeView";
    }
}
