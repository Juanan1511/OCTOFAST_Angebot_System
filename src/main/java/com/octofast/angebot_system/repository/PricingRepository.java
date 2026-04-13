package com.octofast.angebot_system.repository;

import com.octofast.angebot_system.model.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long> {
    // This interface contains already methods such as sve(), load(), findAll(), delete() and others.
}
