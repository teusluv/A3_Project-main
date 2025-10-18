package com.clothes.damafashion.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * The type Stock.
 */
@Data
@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Stock(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Stock() {

    }
}