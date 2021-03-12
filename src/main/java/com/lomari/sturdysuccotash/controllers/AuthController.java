package com.lomari.sturdysuccotash.controllers;

import com.lomari.sturdysuccotash.DTOs.LoginDTO;
import com.lomari.sturdysuccotash.DTOs.SignupDTO;
import com.lomari.sturdysuccotash.auth.MyUserDetailsService;
import com.lomari.sturdysuccotash.model.Admin;
import com.lomari.sturdysuccotash.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    private MyUserDetailsService userDetailsService;

    @Autowired
    public AuthController(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new LoginDTO());
        return "index";
    }

    @GetMapping("/register")
    public String getSignupView(Model model){
        model.addAttribute("user", new SignupDTO());
        return "sign-up";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") SignupDTO user, Model model){
        userDetailsService.signUpUser(user);
        return "redirect:/login";
    }

}
