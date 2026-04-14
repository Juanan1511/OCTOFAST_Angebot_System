package com.octofast.angebot_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;
    private String phone;

    private String address;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Pricing> pricings;

}
