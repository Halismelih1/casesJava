package com.workshop.workshop.Services.dto.requests.Reservation;

import com.workshop.workshop.entities.Car;
import com.workshop.workshop.entities.Customer;
import com.workshop.workshop.entities.Discount;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateReservationRequest {
    private int id;
    private Customer customer;
    private Car car;
    private Discount discount;
    @NotNull(message = "totalPrice cannot be null")
    private int totalPrice;

}
