package com.octofast.angebot_system;


import com.octofast.angebot_system.model.*;
import com.octofast.angebot_system.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class AngebotSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(AngebotSystemApplication.class, args);
    }

/*
    @Bean
    CommandLineRunner init(FactorRepository factorRepository, CostumerRepository costumerRepository, PricingRepository pricingRepository,
                           ProductRepository productRepository, PricingProductRepository pricingProductRepository) {
        return args -> {
            Product producta = new Product();
            producta.setName("Product A");
            producta.setPrice(20.0);
            productRepository.save(producta);

            Product productb = new Product();
            productb.setName("Product B");
            productb.setPrice(30.0);
            productRepository.save(productb);

            Costumer costumer = new Costumer();
            costumer.setName("Costumer A");
            costumer.setLastname("Lastname");
            costumer.setEmail("email@email.com");
            costumer.setPhone("123456789");
            costumer.setAddress("Address");
            Costumer savedCostumer = costumerRepository.save(costumer);

            Factor factor = new Factor();
            factor.setName("Factor A");
            factor.setMultiplier(2.0);
            factorRepository.save(factor);

            Pricing p = new Pricing();
            p.setClient(savedCostumer);
            p.setDescription("Pricing with two products");
            p.setFactor(factor);



            PricingProduct pricingProduct1 = new PricingProduct();
            pricingProduct1.setPricing(p);
            pricingProduct1.setProduct(producta);
            pricingProduct1.setQuantity(1);

            PricingProduct pricingProduct2 = new PricingProduct();
            pricingProduct2.setPricing(p);
            pricingProduct2.setProduct(productb);
            pricingProduct2.setQuantity(1);

            p.setProducts(List.of(pricingProduct1, pricingProduct2));
            p.calculateTotalPrice();
            pricingRepository.save(p);


            System.out.println("¡Primera cotización guardada en SQLite!");
        };
    }

 */

}
