package com.octofast.angebot_system.controller;

import com.octofast.angebot_system.model.Pricing;
import com.octofast.angebot_system.repository.PricingRepository;
import com.octofast.angebot_system.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
public class PricingController {

    @Autowired
    private final PricingService pricingService;
    @Autowired
    private final PricingRepository pricingRepository;

    public PricingController(PricingService pricingService, PricingRepository pricingRepository) {
        this.pricingService = pricingService;
        this.pricingRepository = pricingRepository;
    }

    @GetMapping
    public List<Pricing> getAll(){
        return pricingRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pricing> create(@RequestBody Pricing pricing) {
        Pricing savedPricing = pricingService.savePricing(pricing);
        return ResponseEntity.ok(savedPricing);
    }


    @GetMapping("/costumer/{id}")
    public List<Pricing> getByCostumer(@PathVariable int id) {
        return pricingRepository.findByClient_Id(id);
    }

    @GetMapping("/factor/{id}")
    public List<Pricing> getByFactor(@PathVariable int id) {
        return pricingRepository.findByFactor_Id(id);
    }
}
