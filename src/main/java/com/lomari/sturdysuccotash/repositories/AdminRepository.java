package com.lomari.sturdysuccotash.repositories;

import com.lomari.sturdysuccotash.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    public Optional<Admin> findByEmailAddressAndPassword(String email, String password);
    Optional<Admin> findByEmailAddress(String email);
}
