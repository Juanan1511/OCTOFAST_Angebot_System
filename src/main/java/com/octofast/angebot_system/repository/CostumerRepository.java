package com.octofast.angebot_system.repository;

import com.octofast.angebot_system.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Optional<Costumer> findByEmail(String email);
}
