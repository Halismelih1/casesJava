package com.workshop.workshop.entities;

import jakarta.persistence.*;
import java.util.List;
@Table(name = "customers")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "adress")
    private String adress;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;


}
