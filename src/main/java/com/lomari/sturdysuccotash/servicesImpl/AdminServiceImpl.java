package com.lomari.sturdysuccotash.servicesImpl;

import com.lomari.sturdysuccotash.DTOs.DeletedProductDTO;
import com.lomari.sturdysuccotash.model.Admin;
import com.lomari.sturdysuccotash.model.Product;
import com.lomari.sturdysuccotash.repositories.AdminRepository;
import com.lomari.sturdysuccotash.repositories.ProductRepository;
import com.lomari.sturdysuccotash.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository repository;
    private final ProductRepository productRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    @Override
    public String loginUser(Admin admin, Model model, HttpSession session) {
        boolean result = repository.findByEmailAddressAndPassword(admin.getEmailAddress(),
                admin.getPassword()).isPresent();
        if (result) {
            session.setAttribute("user", "admin");
            model.addAttribute("product", new Product());
            return "admin-home";
        }
        model.addAttribute("result", result);
        return "redirect:/admin";
    }

    @Override
    public String addProduct(Product product, Model model, HttpSession session) {
        if(session.getAttribute("email") == null) return "redirect:/admin";
        productRepository.save(product);
        //TODO: Display a toast message for product successfully added;
        return "admin-home";
    }

    @Override
    public String deleteProduct(DeletedProductDTO dto, Model model, HttpSession session) {
        if(session.getAttribute("email") == null) return "redirect:/admin";
        productRepository.deleteById(dto.getProductId());
        //TODO: Display a toast message for product successfully deleted;
        return "admin-home";
    }
}
