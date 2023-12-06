package com.workshop.workshop.repositories;

import com.workshop.workshop.Services.dto.responses.Discount.DiscountResponse;
import com.workshop.workshop.Services.dto.responses.Reservation.ReservationResponse;
import com.workshop.workshop.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount,Integer> {

    @Query("SELECT new com.workshop.workshop.Services.dto.responses.Discount.DiscountResponse(d.id, d.discountType, d.discountPercent) FROM Discount d WHERE d.discountPercent BETWEEN :minPercent AND :maxPercent")
    List<DiscountResponse> findByDiscountPercentRange(@Param("minPercent") int minPercent, @Param("maxPercent") int maxPercent);

    List<Discount> findByDiscountType(String discountType);


}
