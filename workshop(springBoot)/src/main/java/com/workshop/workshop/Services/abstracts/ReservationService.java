package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.requests.Reservation.AddReservationRequest;
import com.workshop.workshop.Services.dto.requests.Reservation.UpdateReservationRequest;
import com.workshop.workshop.Services.dto.responses.Reservation.ReservationResponse;
import com.workshop.workshop.entities.Reservation;

import java.util.List;

public interface ReservationService {


    void add(AddReservationRequest request);
    void update(int id, UpdateReservationRequest request);
    void delete(int id);
    List<ReservationResponse> findByTotalPriceRange(int minPrice, int maxPrice);
    List<Reservation> getAll();

}
