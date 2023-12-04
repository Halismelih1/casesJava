package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.responses.Car.CarResponse;
import com.workshop.workshop.Services.dto.requests.Car.UpdateCarRequest;
import com.workshop.workshop.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    List<Car> getByBrandId(int brandId);
    List<CarResponse> findByModelJPQL(String model);
    List<Car> getByAvailable(boolean available);
    void add(AddCarRequest request);
    void delete(int id);
    void update(int id, UpdateCarRequest request);
}
