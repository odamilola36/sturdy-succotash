package com.lomari.sturdysuccotash.controllers;

import com.lomari.sturdysuccotash.DTOs.DeletedProductDTO;
import com.lomari.sturdysuccotash.model.Admin;
import com.lomari.sturdysuccotash.model.Product;
import com.lomari.sturdysuccotash.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("")
    public String getLogin(Model model){
        model.addAttribute("user", new Admin());
        return "index";
    }
    @PostMapping("/home")
    public String getDashBoard(@ModelAttribute Admin admin, Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        return adminService.loginUser(admin, model, session);
    }
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product, Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        return  adminService.addProduct(product, model, session);
    }
    @GetMapping("/delete-product")
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
}