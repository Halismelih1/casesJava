package com.workshop.workshop.Services.dto.requests.Reservation;

import com.workshop.workshop.entities.Car;
import com.workshop.workshop.entities.Customer;
import com.workshop.workshop.entities.Discount;
import lombok.Data;

import java.security.PrivateKey;

@Data
public class AddReservationRequest {

    private Customer customer;
    private Car car;
    private Discount discount;
    private int totalPrice;
}
