package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.CarService;
import com.workshop.workshop.Services.dto.brand.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.brand.requests.Car.UpdateCarRequest;
import com.workshop.workshop.entities.Car;
import com.workshop.workshop.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarManager(CarRepository carRepository){
        this.carRepository=carRepository;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        car.setModel(request.getModel());
        car.setAvailable(request.getAvailable());
        car.setBrand(request.getBrand());
        carRepository.save(car);
    }


    @Override
    public void delete(int id) {
        carRepository.deleteById(id);

    }

    @Override
    public void update(int id, UpdateCarRequest request) {
        Car existingCar = carRepository.findById(id).orElseThrow();
        existingCar.setModel(request.getModel());
        existingCar.setAvailable(request.getAvailable());
        existingCar.setBrand(request.getBrand());
        carRepository.save(existingCar);
    }
}
