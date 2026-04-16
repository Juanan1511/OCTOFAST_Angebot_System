package com.octofast.angebot_system.controller;

import com.octofast.angebot_system.model.Factor;
import com.octofast.angebot_system.repository.FactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factor")
public class FactorController {
    @Autowired
    FactorRepository factorRepository;

    @GetMapping
    public List<Factor> getAll() {
        return factorRepository.findAll();
    }

    @PostMapping
    public Factor create(@RequestBody Factor factor) {
        return factorRepository.save(factor);
    }

}
