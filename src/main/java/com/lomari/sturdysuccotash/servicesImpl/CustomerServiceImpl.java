package com.lomari.sturdysuccotash.servicesImpl;

import com.lomari.sturdysuccotash.DTOs.LoginDTO;
import com.lomari.sturdysuccotash.DTOs.SignupDTO;
import com.lomari.sturdysuccotash.exceptions.ProductNotFoundException;
import com.lomari.sturdysuccotash.model.Customer;
import com.lomari.sturdysuccotash.model.Product;
import com.lomari.sturdysuccotash.repositories.CustomerRepository;
import com.lomari.sturdysuccotash.repositories.ProductRepository;
import com.lomari.sturdysuccotash.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final ProductRepository repository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ProductRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) return product.get();
        throw new ProductNotFoundException("specified product could not be found");
    }
    @Override
    public void signUpUser(SignupDTO signupDTO){
        Customer customer = new Customer();
        customer.setFullName(signupDTO.getFullName());
        customer.setAddress(signupDTO.getAddress());
        customer.setEmailAddress(signupDTO.getEmailAddress());
        customer.setPassword(signupDTO.getPassword());
        customer.setPhoneNumber(signupDTO.getPhoneNumber());

        customerRepository.save(customer);
    }
    @Override
    public String loginUser(LoginDTO userDTO, HttpServletRequest req){
        HttpSession session = req.getSession();
        Object signedInUser = session.getAttribute("user");
        return "redirect:/";
    }
}
