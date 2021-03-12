package com.lomari.sturdysuccotash.repositories;

import com.lomari.sturdysuccotash.model.Admin;
import com.lomari.sturdysuccotash.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Optional<Customer> findByEmailAddressAndPassword(String email, String password);
    Optional<Customer> findByEmailAddress(String email);
    Boolean existsByEmailAddress(String email);
}
