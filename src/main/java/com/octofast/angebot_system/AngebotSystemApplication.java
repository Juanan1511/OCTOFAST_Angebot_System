package com.octofast.angebot_system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AngebotSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(AngebotSystemApplication.class, args);
    }

    /*
    @Bean
    CommandLineRunner init(PricingRepository pricingRepository) {
        return args -> {
            Pricing p = new Pricing();
            p.setClient("Cliente de Prueba"); // Asegúrate que coincida con Pricing.java
            p.setPrice(150.50);               // Asegúrate que coincida con Pricing.java
            pricingRepository.save(p);
            System.out.println("¡Primera cotización guardada en SQLite!");
        };
    }

     */


}
