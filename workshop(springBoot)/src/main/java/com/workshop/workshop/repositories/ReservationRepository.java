package com.workshop.workshop.repositories;

import com.workshop.workshop.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Integer>
    {

        @Query("SELECT r FROM Reservation r WHERE r.totalPrice BETWEEN :minPrice AND :maxPrice")
        List<Reservation> findByTotalPriceRange(@Param("minPrice") int minPrice, @Param("maxPrice") int maxPrice);
        List<Reservation> findAll();
    }
