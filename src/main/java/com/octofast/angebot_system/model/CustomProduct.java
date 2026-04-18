package com.octofast.angebot_system.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("CUSTOM")
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomProduct extends Product {
    private String fabricationDetails;
}
