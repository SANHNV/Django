package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import com.django.Configuration.ProductTR;
import com.django.Models.Product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class ProductListController {
    
    @RequestMapping({"/productList"})
    public String showProducts(@RequestParam(value = "name", defaultValue = "World", required = true) String name, Model model) {
        System.out.println("controller products");
        AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");
        model.addAttribute("name", name);
        List<Product> products = myApplicationContext.getBean(ProductTR.class).getProducts();
        model.addAttribute("productList",products);
        System.out.println(products.size());
        myApplicationContext.close();
        return "productListView";
    }

    // @RequestMapping("/")
	// public ModelAndView home(ModelAndView modelAndView) {
		
	// 	modelAndView.setViewName("home");
	// 	modelAndView.getModel().put("name", "John");
    //     System.out.println("controller hello");
	// 	return modelAndView;
	// }
}
