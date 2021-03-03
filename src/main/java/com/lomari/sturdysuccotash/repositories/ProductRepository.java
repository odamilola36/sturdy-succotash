package com.lomari.sturdysuccotash.repositories;

import com.lomari.sturdysuccotash.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
