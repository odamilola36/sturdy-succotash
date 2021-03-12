package com.lomari.sturdysuccotash.services;

import com.lomari.sturdysuccotash.DTOs.LoginDTO;
import com.lomari.sturdysuccotash.DTOs.SignupDTO;
import com.lomari.sturdysuccotash.exceptions.ProductNotFoundException;
import com.lomari.sturdysuccotash.model.Product;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public interface CustomerService {
    Iterable<Product> getProducts();

    Product getProduct(Long id) throws ProductNotFoundException;

    void signUpUser(SignupDTO signupDTO);


//    String loginUser(LoginDTO user, Model model, HttpServletRequest request);
}
