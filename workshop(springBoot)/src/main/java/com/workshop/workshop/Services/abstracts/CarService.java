package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.brand.requests.Car.UpdateCarRequest;

public interface CarService {
    void add(AddCarRequest request);
    void delete(int id);
    void update(int id, UpdateCarRequest request);
}
