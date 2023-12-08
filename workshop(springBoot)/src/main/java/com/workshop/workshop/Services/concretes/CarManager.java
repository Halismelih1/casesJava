package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.CarService;
import com.workshop.workshop.Services.dto.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.responses.Car.CarResponse;
import com.workshop.workshop.Services.dto.requests.Car.UpdateCarRequest;
import com.workshop.workshop.entities.Car;
import com.workshop.workshop.repositories.CarRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {

    @PersistenceContext
    private EntityManager entityManager;
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

        // İş kuralları
        businessRulesCar(car);

        carRepository.save(car);
    }

    private void businessRulesCar(Car car) {
        if ("E-200".equals(car.getModel()) && !car.getBrand().getBrandName().equals("Mercedes")) {
            throw new IllegalStateException("E-200 model cars can only be of Mercedes brand.");
        }

        if ("M-5".equals(car.getModel()) && !car.getBrand().getBrandName().equals("Bmw")) {
            throw new IllegalStateException("M-5 model cars can only be of Bmw brand.");
        }
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

    @Override
    public List<Car> getByBrandId(int brandId) {
        return carRepository.findByBrandId(brandId);
    }

    @Override
    public List<Car> getByAvailable(boolean available) {
        return carRepository.findByAvailable(available);
    }

    @Override
    public List<CarResponse> findByModelJPQL(String model) {

        //TODO : StreamApi Used


        //return carRepository.findByModelJPQL(model);

        List<CarResponse> carList = carRepository.findByModelJPQL(model);

        return carList.stream()
                .map(car -> new CarResponse(car.getId(), car.getModel(), car.getAvailable(), car.getBrand()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }}


