package com.octofast.angebot_system.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("PHYSICAL")
@Data
@EqualsAndHashCode(callSuper = true)
public class PhysicalProduct extends Product{
    private Integer stock;
}
