package com.octofast.angebot_system.controller;

import com.octofast.angebot_system.model.Costumer;
import com.octofast.angebot_system.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/costumer")
public class CostumerController {
    @Autowired
    private CostumerRepository costumerRepository;

    @GetMapping
    public List<Costumer> getAll() {
        return costumerRepository.findAll();
    }

    @PostMapping
    public Costumer create(@RequestBody Costumer costumer) {
        return costumerRepository.save(costumer);
    }

}
