package com.octofast.angebot_system.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pricing_products")
@Data
public class PricingProduct {
    @EmbeddedId
    private PricingProductId id = new PricingProductId();

    @ManyToOne
    @MapsId("pricingId")
    @JoinColumn(name = "pricing_id")
    @JsonIgnore
    private Pricing pricing;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private Double price;

    public void calculateStock(PhysicalProduct pp) {
        if (pp.getStock() < this.quantity) {
            throw new RuntimeException("Insufficient Stock for Product:" + pp.getName());
        }
        pp.setStock(pp.getStock() - this.quantity);
    }
}
