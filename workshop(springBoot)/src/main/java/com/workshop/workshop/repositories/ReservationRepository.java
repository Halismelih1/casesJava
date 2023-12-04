package com.workshop.workshop.repositories;

import com.workshop.workshop.Services.dto.responses.Reservation.ReservationResponse;
import com.workshop.workshop.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>
    {

        @Query("SELECT new com.workshop.workshop.Services.dto.responses.Reservation.ReservationResponse" +
                "(r.id, r.totalPrice, r.customer, r.car, r.discount) FROM Reservation r WHERE r.totalPrice BETWEEN :minPrice AND :maxPrice")
        List<ReservationResponse> findByTotalPriceRange(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);



    }
