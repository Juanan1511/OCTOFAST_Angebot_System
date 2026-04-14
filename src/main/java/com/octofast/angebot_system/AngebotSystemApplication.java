package com.octofast.angebot_system;


import com.octofast.angebot_system.model.Costumer;
import com.octofast.angebot_system.model.Pricing;
import com.octofast.angebot_system.repository.CostumerRepository;
import com.octofast.angebot_system.repository.PricingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AngebotSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(AngebotSystemApplication.class, args);
    }
/*
    @Bean
    CommandLineRunner init(CostumerRepository costumerRepository, PricingRepository pricingRepository) {
        return args -> {
            Costumer costumer = new Costumer();
            costumer.setName("Costumer A");
            costumer.setLastname("Lastname");
            costumer.setEmail("email@email.com");
            costumer.setPhone("123456789");
            costumer.setAddress("Address");
            Costumer savedCostumer = costumerRepository.save(costumer);


            Pricing p = new Pricing();
            p.setClient(savedCostumer);
            p.setPrice(150.50);
            pricingRepository.save(p);
            System.out.println("¡Primera cotización guardada en SQLite!");
        };
    }

 */






}
