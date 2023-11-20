package com.workshop.workshop.repositories;

import com.workshop.workshop.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>
{
}
