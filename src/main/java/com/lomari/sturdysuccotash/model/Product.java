package com.lomari.sturdysuccotash.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String price;
    private String description;
    private String imageUrl;
    private int stock;

    @ManyToOne
    private Order order;
}
