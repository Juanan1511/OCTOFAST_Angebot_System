package com.octofast.angebot_system.service;

import com.octofast.angebot_system.model.PhysicalProduct;
import com.octofast.angebot_system.model.Pricing;
import com.octofast.angebot_system.model.PricingProduct;
import com.octofast.angebot_system.repository.PricingRepository;
import com.octofast.angebot_system.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    private final PricingRepository pricingRepository;
    private final ProductRepository productRepository;

    public PricingService(PricingRepository pricingRepository, ProductRepository productRepository) {
        this.pricingRepository = pricingRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Pricing savePricing(Pricing pricing) {
        for (PricingProduct pp : pricing.getProducts()) {
            if (pp.getProduct() instanceof PhysicalProduct physical) {
                pp.calculateStock(physical);
                productRepository.save(physical);
            }
        }

        pricing.calculateTotalPrice();

        return pricingRepository.save(pricing);
    }
}
