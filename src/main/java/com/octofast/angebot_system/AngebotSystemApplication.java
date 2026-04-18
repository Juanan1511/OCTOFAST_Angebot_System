package com.octofast.angebot_system;


import com.octofast.angebot_system.model.*;
import com.octofast.angebot_system.repository.*;
import com.octofast.angebot_system.service.PricingService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


@SpringBootApplication
public class AngebotSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(AngebotSystemApplication.class, args);
    }


    @Bean
    @Transactional // Ensures all database changes are committed as a single unit
    CommandLineRunner init(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, FactorRepository factorRepository, CostumerRepository costumerRepository, PricingRepository pricingRepository,
                           ProductRepository productRepository, PricingService pricingService) {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                User admin = new User();
                admin.setUsername("admin");

                String password = "admin123";
                admin.setPassword(passwordEncoder.encode(password));

                admin.setRole("ADMIN");
                userRepository.save(admin);

                System.out.println("--- Seguridad Inicializada ---");
                System.out.println("Usuario 'admin' creado con éxito.");
            }

            if (productRepository.findAll().isEmpty()) {
                PhysicalProduct bolt = new PhysicalProduct();
                bolt.setName("Hex Bolt M8");
                bolt.setPrice(1.20);
                bolt.setStock(500);
                productRepository.save(bolt);

                CustomProduct desk = new CustomProduct();
                desk.setName("Custom Oak Desk");
                desk.setPrice(1200.0);
                desk.setFabricationDetails("Solid oak, 180x80cm, natural finish");
                productRepository.save(desk);


                Pricing offer = new Pricing();
                offer.setDescription("Office Furniture Quote");


                Costumer costumer = new Costumer();
                costumer.setName("Costumer A");
                costumer.setLastname("Lastname");
                costumer.setEmail("email@email.com");
                costumer.setPhone("123456789");
                costumer.setAddress("Address");
                Costumer savedCostumer = costumerRepository.save(costumer);

                offer.setClient(savedCostumer);

                Factor factor = new Factor();
                factor.setName("Factor A");
                factor.setMultiplier(2.0);
                Factor savedFactor = factorRepository.save(factor);

                offer.setFactor(savedFactor);


                PricingProduct item1 = new PricingProduct();
                item1.setPricing(offer);
                item1.setProduct(bolt);
                item1.setQuantity(50);

                PricingProduct item2 = new PricingProduct();
                item2.setPricing(offer);
                item2.setProduct(desk);
                item2.setQuantity(1);

                offer.setProducts(List.of(item1, item2));

                pricingService.savePricing(offer);

                // Thanks to @Transactional, 'bolt' is updated in SQLite automatically
                // with 450 units without calling productRepository.save(bolt) again.


                System.out.println("¡First pricing saved in SQLite!");
            }

        };
    }




}
