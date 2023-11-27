package com.workshop.workshop.repositories;

import com.workshop.workshop.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer>
{
    List<Car> findByBrandId(int brandId);
    List<Car> findByAvailable(boolean available);
    @Query("SELECT c FROM Car c WHERE c.model = :model")
    List<Car>findByModelJPQL(@Param("model")String model);
}
