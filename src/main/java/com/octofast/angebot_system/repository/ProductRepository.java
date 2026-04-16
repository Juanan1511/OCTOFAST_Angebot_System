package com.octofast.angebot_system.repository;

import com.octofast.angebot_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // This interface contains already methods such as sve(), load(), findAll(), delete() and others.

}
