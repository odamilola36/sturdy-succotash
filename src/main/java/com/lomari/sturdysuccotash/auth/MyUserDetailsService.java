package com.lomari.sturdysuccotash.auth;

import com.lomari.sturdysuccotash.DTOs.SignupDTO;
import com.lomari.sturdysuccotash.model.Admin;
import com.lomari.sturdysuccotash.model.Customer;
import com.lomari.sturdysuccotash.repositories.AdminRepository;
import com.lomari.sturdysuccotash.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private CustomerRepository customerRepository;

    @Autowired
    public MyUserDetailsService(PasswordEncoder passwordEncoder, CustomerRepository customerRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmailAddress(email);

        customer.orElseThrow(()-> new UsernameNotFoundException(String.format("user %s not found", email)));

        return customer.map(ApplicationUser::new).get();
    }


    public void signUpUser(SignupDTO user) {
        Customer newCustomer = new Customer();
        newCustomer.setEmailAddress(user.getEmailAddress());
        newCustomer.setPhoneNumber(user.getPhoneNumber());
        newCustomer.setAddress(user.getAddress());
        newCustomer.setRole("CUSTOMER");
        newCustomer.setFullName(user.getFullName());
        newCustomer.setPassword(passwordEncoder.encode(user.getPassword()));

        customerRepository.save(newCustomer);
    }
}
