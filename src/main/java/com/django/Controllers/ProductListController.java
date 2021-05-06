package com.django.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.django.Models.Product;
import com.django.Services.DatabaseService;

//TODO: put all database TR in service


@Controller
public class ProductListController {
    
    DatabaseService dbService = new DatabaseService();

    @RequestMapping({"/productList"})
    public String showProducts(@RequestParam(value = "error", defaultValue = "", required = true) String error, Model model) {
        System.out.println("controller products list");
        //get all products
        List<Product> products = DatabaseService.getProducts();
        model.addAttribute("productList",products);
        model.addAttribute("errorString", error);
        return "productListView";
    }

    @RequestMapping({"/createProduct"})
    public String createProduct(@RequestParam(value = "error", defaultValue = "", required = true) String error, Model model) {
        System.out.println("controller products create");

        Product product = new Product(0, "Chartreuse", "34.5", "url", new Timestamp(System.currentTimeMillis()),10);

        DatabaseService.saveProduct(product);
        //test
        //Product product = new Product(0, "Chartreuse", "34.5", "url", new Timestamp(System.currentTimeMillis()),10);
        //model.addAttribute("product", product);
        return "createProductView";
    }

    @RequestMapping("/editProduct")
    public String editProduct(@RequestParam(value = "code", defaultValue = "0", required = true) String code, Model model) {
        System.out.println("controller products get edit view");

        Product product = DatabaseService.getSingleProduct(Integer.parseInt( code));
        if(product == null){
            return "redirect:/productList?errorString=ProductNotFound";
        }        
        model.addAttribute("date",TimeUnit.DAYS.convert(product.getLimitDate().getTime() - new Timestamp(System.currentTimeMillis()).getTime() , TimeUnit.MILLISECONDS)+1);
        model.addAttribute("product", product);
        return "createProductView";
    }

    @RequestMapping(value ="/addProduct", method = RequestMethod.POST)
    public String editProduct(@RequestBody Product product) {
        System.out.println("controller products edit product");
        //if product model valid
        if(product.getIdProduct() == 0){
            DatabaseService.saveProduct(product);
        } else {
            //TODO: add edit save
        }
        //else
        // return "redirect:/productList?errorString=errorAddProduct";
        return "redirect:/productList";
    }

    @RequestMapping({"/deleteProduct"})
    public String deleteProduct(@RequestParam(value = "code", defaultValue = "0", required = true) String code, Model model) {
        System.out.println("controller delete product");
        //if or try
        DatabaseService.deleteProduct(Integer.parseInt(code));
        //else or catch
        model.addAttribute("errorString", "error with delete");
        return "redirect:/productList";
    }

    /**
     * Show login view
     * @return ModelAndView
     */
    @RequestMapping(value = "/createProduct", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        System.out.println("controller login");
        return new ModelAndView("createProductView", "product", new Product()) ;
    }

    @RequestMapping(value = "/createP", method = RequestMethod.POST)
    public String createP(String idProduct,String name, String price, String image,String limitDate, String quantity){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(limitDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }  
        Product product = null;
        Double q = Double.parseDouble(quantity);
        if(idProduct != null){
            product = new Product(Integer.parseInt(idProduct),name,price,image,new Timestamp(date.getTime()),q);
        }
        else{
            product = new Product(name,price,image,new Timestamp(date.getTime()),q);
        }
        
        DatabaseService.saveProduct(product);
        return "redirect:/productList";
    }
}
