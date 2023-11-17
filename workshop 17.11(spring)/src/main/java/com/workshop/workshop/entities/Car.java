package com.workshop.workshop.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "available")
    private Boolean available;
    @OneToMany(mappedBy = "car")
    private List<Reservation>reservations;


}
