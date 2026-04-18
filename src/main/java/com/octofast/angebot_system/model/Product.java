package com.octofast.angebot_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Crea una sola tabla "product"
@DiscriminatorColumn(name = "product_type")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Double price;



}
