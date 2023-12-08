package com.workshop.workshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Table(name = "brands")
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int id;

    @Column(name = "brand_name")
    @Size(max = 15, message = "brandName length must be at most 15 characters")
    @NotBlank
    @NotNull(message = "brandName cannot be null")
    private String brandName;

    @Column(name = "contracted_gas_station")
    private String contractedGasStation;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Car>cars;
}
