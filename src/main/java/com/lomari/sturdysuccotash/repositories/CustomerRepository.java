package com.lomari.sturdysuccotash.repositories;

import com.lomari.sturdysuccotash.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository {
    public Optional<Admin> findByEmailAddressAndPassword(String email, String password);
}
