package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

import com.django.Models.Product;

import org.springframework.stereotype.Controller;

@Controller
public class ProductListController {
    
    @RequestMapping({"/productList"})
    public String showProducts(@RequestParam(value = "error", defaultValue = "", required = true) String error, Model model) {
        System.out.println("controller products list");

        //get all products
        model.addAttribute("errorString", error);
        return "productListView";
    }

    @RequestMapping({"/createProduct"})
    public String createProduct(@RequestParam(value = "error", defaultValue = "", required = true) String error, Model model) {
        System.out.println("controller products create");
        Product product = new Product(123, "Chartreuse", "34.5", "url", new Timestamp(System.currentTimeMillis()),10);
        model.addAttribute("product", product);
        return "createProductView";
    }

    @RequestMapping("/editProduct")
    public String editProduct(@RequestParam(value = "code", defaultValue = "0", required = true) String name, Model model) {
        System.out.println("controller products get edit view");
        //get product by id
        Product product = new Product(123, "Chartreuse", "34.5", "url", new Timestamp(System.currentTimeMillis()),10);
        model.addAttribute("product", product);
        return "createProductView";
    }

    @RequestMapping(value ="/addProduct", method = RequestMethod.POST)
    public String editProduct(@RequestBody Product product) {
        System.out.println("controller products edit product");
        //if product model valid
        //  if id == 0
        //    create new product
        //   else
        //     edit product
        //else
        // return "redirect:/productList?errorString=errorAddProduct";
        return "redirect:/productList";
    }

    @RequestMapping({"/deleteProduct"})
    public String deleteProduct(@RequestParam(value = "code", defaultValue = "0", required = true) String name, Model model) {
        System.out.println("controller products create");
        //if or try
        //call delete product method
        //else or catch
        model.addAttribute("errorString", "error with delete");
        return "redirect:/productList";
    }
}
