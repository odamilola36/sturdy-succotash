package com.lomari.sturdysuccotash.controllers;

import com.lomari.sturdysuccotash.DTOs.DeletedProductDTO;
import com.lomari.sturdysuccotash.model.Admin;
import com.lomari.sturdysuccotash.model.Product;
import com.lomari.sturdysuccotash.repositories.CustomerRepository;
import com.lomari.sturdysuccotash.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private AdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/home")
    public String getAdminHome(Model model){
        logger.info(passwordEncoder.encode("password123"));
        model.addAttribute("product", new Product());
        return "admin-home";

    }

    @PostMapping("/add-product")//rename to product/add
    public String addProduct(@ModelAttribute Product product, Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        return  adminService.addProduct(product, model, session);
    }
    @GetMapping("/delete-product")//rename the route to product/delete instead
    public String deleteProduct(Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        model.addAttribute("delete", new DeletedProductDTO());
        if (session.getAttribute("user") == null) return "redirect:/admin/";
        return "delete-product";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute DeletedProductDTO dto, Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        return adminService.deleteProduct(dto, model, session);
    }
    @GetMapping("/product/update")
    public String getProductUpdate(Model model){
        return "";
    }
}