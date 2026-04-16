package com.octofast.angebot_system.repository;

import com.octofast.angebot_system.model.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorRepository extends JpaRepository<Factor, Long> {
    // This interface contains already methods such as sve(), load(), findAll(), delete() and others.
}
