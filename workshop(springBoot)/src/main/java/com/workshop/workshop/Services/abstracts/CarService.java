package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.brand.requests.Car.UpdateCarRequest;
import com.workshop.workshop.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getByBrandId(int brandId);
    List<Car> findByModelJPQL(String model);
    List<Car> getByAvailable(boolean available);
    void add(AddCarRequest request);
    void delete(int id);
    void update(int id, UpdateCarRequest request);
}
