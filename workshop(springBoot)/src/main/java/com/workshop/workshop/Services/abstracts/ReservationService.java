package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Reservation.AddReservationRequest;
import com.workshop.workshop.Services.dto.brand.requests.Reservation.UpdateReservationRequest;
import com.workshop.workshop.entities.Reservation;
import com.workshop.workshop.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public interface ReservationService {


    void add(AddReservationRequest request);
    void update(int id, UpdateReservationRequest request);
    void delete(int id);
    List<Reservation> findByTotalPriceRange(int minPrice, int maxPrice);
    List<Reservation> getAll();

}
