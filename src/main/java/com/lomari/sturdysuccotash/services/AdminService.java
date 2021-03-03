package com.lomari.sturdysuccotash.services;

import com.lomari.sturdysuccotash.DTOs.DeletedProductDTO;
import com.lomari.sturdysuccotash.model.Admin;
import com.lomari.sturdysuccotash.model.Product;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

//@Service
public interface AdminService {
    public String loginUser(Admin admin, Model model, HttpSession session);
    public String addProduct(Product product, Model model, HttpSession session);
    public String deleteProduct(DeletedProductDTO dto, Model model, HttpSession session);
}
