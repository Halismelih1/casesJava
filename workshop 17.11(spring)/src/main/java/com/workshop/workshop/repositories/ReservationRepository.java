package com.workshop.workshop.repositories;

import com.workshop.workshop.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ReservationRepository extends JpaRepository<Reservation,Integer>
    {
    }
