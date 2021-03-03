package com.lomari.sturdysuccotash.controllers;

import com.lomari.sturdysuccotash.DTOs.LoginDTO;
import com.lomari.sturdysuccotash.DTOs.SignupDTO;
import com.lomari.sturdysuccotash.exceptions.ProductNotFoundException;
import com.lomari.sturdysuccotash.model.Product;
import com.lomari.sturdysuccotash.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String getHomePage(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("user", null);
        model.addAttribute("items", customerService.getProducts());
        return "home";
    }
    @GetMapping("/signin")
    public String getSignin(Model model){
        model.addAttribute("login", new LoginDTO());
        return null;
    }
    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model, HttpServletRequest req){
        //TODO: on successful login, redirect to the previous page;
        String ref = req.getHeader("Referrer");
        return "redirect:" + ref;
    }
    @GetMapping("/signup")
    public String getSignup(Model model){
        model.addAttribute("user", new SignupDTO());
        return "sign-up";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute SignupDTO signup, Model model, HttpServletRequest req){
        customerService.signUpUser(signup);
        String ref = req.getHeader("Referrer");
        return "redirect:" + ref;
    }
    @GetMapping("/product-details/{id}")
    public String productDetails(@PathVariable("id") Long id, Model model){
        log.info(String.valueOf(id));
        try {
            Product product = customerService.getProduct(id);
            model.addAttribute("item", product);
        } catch (ProductNotFoundException e){e.printStackTrace();}
        return "product-details";
    }
    @GetMapping("/add-to-cart")
    public String addToCart(@PathVariable("id") Long id, Model model, HttpServletRequest req){
        return null;
    }
}
