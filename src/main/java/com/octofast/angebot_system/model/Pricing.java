package com.octofast.angebot_system.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pricing")
@Data
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "clientid", nullable = false)
    private Costumer client;

    @ManyToOne
    @JoinColumn(name = "factorid", nullable = false)
    private Factor factor;


    @OneToMany(mappedBy = "pricing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PricingProduct> products;

    private String description;


    private Double price;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
    }

    public void calculateTotalPrice(){
        if(this.products == null || this.products.isEmpty()){
            this.price = 0.0;
            return;
        }
        Double baseCost = products.stream()
                .mapToDouble(product -> product.getProduct().getPrice() * product.getQuantity())
                .sum();
        this.price = baseCost * this.factor.getMultiplier();
    }
}
