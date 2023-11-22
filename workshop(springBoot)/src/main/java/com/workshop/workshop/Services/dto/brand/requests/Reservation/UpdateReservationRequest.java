package com.workshop.workshop.Services.dto.brand.requests.Reservation;

import com.workshop.workshop.entities.Car;
import com.workshop.workshop.entities.Customer;
import com.workshop.workshop.entities.Discount;
import lombok.Data;

@Data
public class UpdateReservationRequest {
    private int id;
    private Customer customer;
    private Car car;
    private Discount discount;
    private int totalPrice;

}
