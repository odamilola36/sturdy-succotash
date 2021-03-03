package com.lomari.sturdysuccotash.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailAddress;
    private String password;
    private String fullName;
    private String address;
    private String phoneNumber;
    @OneToMany
    private List<Product> cartItems;
}
