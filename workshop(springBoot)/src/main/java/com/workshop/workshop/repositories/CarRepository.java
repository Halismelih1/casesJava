package com.workshop.workshop.repositories;

import com.workshop.workshop.Services.dto.responses.Car.CarResponse;
import com.workshop.workshop.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Collectors;

public interface CarRepository extends JpaRepository<Car, Integer>
{
    List<Car> findByBrandId(int brandId);
    List<Car> findByAvailable(boolean available);
    @Query("SELECT new com.workshop.workshop.Services.dto.responses.Car.CarResponse(c.id, c.model, c.available, c.brand) FROM Car c INNER JOIN c.brand b WHERE c.model = :model")
    List<CarResponse> findByModelJPQL(@Param("model") String model);
    List<Car> findAll();

}
