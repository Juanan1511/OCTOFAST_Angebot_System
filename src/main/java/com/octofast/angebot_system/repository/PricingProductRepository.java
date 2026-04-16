package com.octofast.angebot_system.repository;

import com.octofast.angebot_system.model.PricingProduct;
import com.octofast.angebot_system.model.PricingProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricingProductRepository extends JpaRepository<PricingProduct, PricingProductId> {
    List<PricingProduct> findByPricingId(Long pricingId);
}
