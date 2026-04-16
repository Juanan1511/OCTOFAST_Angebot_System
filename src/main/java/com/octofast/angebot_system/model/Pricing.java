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


    @OneToMany(mappedBy = "pricing", cascade = CascadeType.ALL)
    private List<PricingProduct> products;

    private String description;


    private Double price;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
    }
}
