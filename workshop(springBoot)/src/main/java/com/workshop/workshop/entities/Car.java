package com.workshop.workshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;


@Entity
@Table(name = "cars")
@Getter
@Setter

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "model")
    @Size(max = 10, message = "Model length must be at most 10 characters")
    @NotBlank(message = "Model cannot be blank")
    private String model;

    @Column(name = "available")
    @NotNull(message = "Available status cannot be null")
    private Boolean available;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation>reservations;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull(message = "Brand cannot be null")
    private Brand brand;






}
