package com.octofast.angebot_system.controller;

import com.octofast.angebot_system.model.PricingProduct;
import com.octofast.angebot_system.repository.PricingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing-products")
public class PricingProductController {
    @Autowired
    private PricingProductRepository pricingProductRepository;

    @GetMapping
    public List<PricingProduct> getAll() {
        return pricingProductRepository.findAll();
    }

    @PostMapping
    public PricingProduct addProductToPricing(@RequestBody PricingProduct pricingProduct) {
        return pricingProductRepository.save(pricingProduct);
    }

    @GetMapping("/pricing/{pricingId}")
    public List<PricingProduct> getPricingProduct(@PathVariable Long pricingId) {
        return pricingProductRepository.findByPricingId(pricingId);
    }
}
