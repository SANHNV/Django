package com.django.Controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.django.Configuration.ProductTR;
import com.django.Models.Product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateProductController {
    
    @RequestMapping({"/createProduct"})
    public String showProducts(@RequestParam(value = "name", defaultValue = "World", required = true) String name, Model model) {
        System.out.println("controller Create Product");
        AnnotationConfigApplicationContext  myApplicationContext = new AnnotationConfigApplicationContext("com.django");

        List<Product> products = myApplicationContext.getBean(ProductTR.class).getProducts();
        
        Date d = new Date();
        Product temp = new Product(products.size()+1,"test","10,00","",new Timestamp(d.getTime()),2.2);
        model.addAttribute("name", name);
        myApplicationContext.getBean(ProductTR.class).saveProduct(temp);

        products = myApplicationContext.getBean(ProductTR.class).getProducts();
        model.addAttribute("productList",products);

        myApplicationContext.close();
        return "productListView";
    }
}
