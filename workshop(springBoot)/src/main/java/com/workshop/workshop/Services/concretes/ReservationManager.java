package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.ReservationService;
import com.workshop.workshop.Services.dto.brand.requests.Reservation.AddReservationRequest;
import com.workshop.workshop.Services.dto.brand.requests.Reservation.UpdateReservationRequest;
import com.workshop.workshop.entities.Reservation;
import com.workshop.workshop.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationManager implements ReservationService {

    private final ReservationRepository reservationRepository;
    @Autowired
    public ReservationManager(ReservationRepository reservationRepository){
        this.reservationRepository=reservationRepository;
    }

    @Override
    public void add(AddReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setTotalPrice(request.getTotalPrice());
        reservation.setCar(request.getCar());
        reservation.setCustomer(request.getCustomer());
        reservation.setDiscount(request.getDiscount());
        reservationRepository.save(reservation);

    }

    @Override
    public void update(int id, UpdateReservationRequest request) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow();
        existingReservation.setTotalPrice(request.getTotalPrice());
        existingReservation.setCar(existingReservation.getCar());
        existingReservation.setDiscount(existingReservation.getDiscount());
        existingReservation.setCustomer(request.getCustomer());
        reservationRepository.save(existingReservation);

    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public List<Reservation> findByTotalPriceRange(int minPrice, int maxPrice) {
        return reservationRepository.findByTotalPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
