package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.AddReservationRequest;
import com.workshop.workshop.Services.dto.brand.requests.UpdateReservationRequest;

public interface ReservationService {
    void add(AddReservationRequest request);
    void update(int id, UpdateReservationRequest request);
    void delete(int id);
}
