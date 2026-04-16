package com.octofast.angebot_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Factor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double multiplier;
}
