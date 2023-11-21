package com.workshop.workshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;


@Entity
@Table(name = "discounts")
@Getter
@Setter
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int id;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "discount_percent")
    private int discountPercent;

    @OneToMany(mappedBy = "discount")
    @JsonIgnore
    private List<Reservation>reservations;





}
