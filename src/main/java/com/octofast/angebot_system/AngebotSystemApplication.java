package com.octofast.angebot_system;


import com.octofast.angebot_system.model.Costumer;
import com.octofast.angebot_system.model.Pricing;
import com.octofast.angebot_system.model.PricingProduct;
import com.octofast.angebot_system.model.Product;
import com.octofast.angebot_system.repository.CostumerRepository;
import com.octofast.angebot_system.repository.PricingProductRepository;
import com.octofast.angebot_system.repository.PricingRepository;
import com.octofast.angebot_system.repository.ProductRepository;
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
    CommandLineRunner init(CostumerRepository costumerRepository, PricingRepository pricingRepository,
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

            Pricing p = new Pricing();
            p.setClient(savedCostumer);
            p.setPrice(producta.getPrice() + productb.getPrice());
            p.setDescription("Pricing with two products");
            pricingRepository.save(p);


            PricingProduct pricingProduct1 = new PricingProduct();
            pricingProduct1.setPricing(p);
            pricingProduct1.setProduct(producta);
            pricingProduct1.setQuantity(1);
            pricingProductRepository.save(pricingProduct1);

            PricingProduct pricingProduct2 = new PricingProduct();
            pricingProduct2.setPricing(p);
            pricingProduct2.setProduct(productb);
            pricingProduct2.setQuantity(1);
            pricingProductRepository.save(pricingProduct2);

            System.out.println("¡Primera cotización guardada en SQLite!");
        };
    }

     */







}
