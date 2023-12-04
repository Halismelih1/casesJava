package com.workshop.workshop.Services.dto.responses.Reservation;

import com.workshop.workshop.entities.Car;
import com.workshop.workshop.entities.Customer;
import com.workshop.workshop.entities.Discount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationResponse {
  private int id;
  private int totalPrice;
  private Customer customer;
  private Car car;
  private Discount discount;
}
