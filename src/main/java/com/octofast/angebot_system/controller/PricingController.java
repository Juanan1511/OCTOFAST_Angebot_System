package com.octofast.angebot_system.controller;

import com.octofast.angebot_system.model.Pricing;
import com.octofast.angebot_system.repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
public class PricingController {

    @Autowired
    private PricingRepository pricingRepository;

    @GetMapping
    public List<Pricing> getAll(){
        return pricingRepository.findAll();
    }

    @PostMapping
    public Pricing create(@RequestBody Pricing pricing) {
        return pricingRepository.save(pricing);
    }

    @GetMapping("/costumer/{id}")
    public List<Pricing> getByCostumer(@PathVariable int id) {
        return pricingRepository.findByClient_Id(id);
    }
}
