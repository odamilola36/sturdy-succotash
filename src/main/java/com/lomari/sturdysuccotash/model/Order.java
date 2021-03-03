package com.lomari.sturdysuccotash.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Table(name = "product_orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @OneToMany(mappedBy = "order")
    private List<Product> products;

    //many to one users
//    @ManyToOne
//    private List<P>


    @Column
    private double amount;

    @Column
    private boolean paymentStatus;
}
