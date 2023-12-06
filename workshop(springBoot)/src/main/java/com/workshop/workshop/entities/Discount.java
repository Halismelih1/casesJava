package com.workshop.workshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "discountType  cannot be null")
    private String discountType;

    @Column(name = "discount_percent")
    @NotNull(message = "discountPercent cannot be null")
    private int discountPercent;

    @OneToMany(mappedBy = "discount",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation>reservations;





}
