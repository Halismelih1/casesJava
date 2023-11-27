package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.CarService;
import com.workshop.workshop.Services.dto.brand.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.brand.requests.Car.UpdateCarRequest;
import com.workshop.workshop.entities.Car;
import com.workshop.workshop.repositories.CarRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Car> getByBrandId(int brandId) {
        return carRepository.findByBrandId(brandId);
    }



    @Override
    public List<Car> getByAvailable(boolean available) {
        return carRepository.findByAvailable(available);
    }

    @Override
    public List<Car> findByModelJPQL(String model) {
        String jpqlQuery = "SELECT c FROM Car c WHERE c.model = :model";
        return entityManager.createQuery(jpqlQuery, Car.class)
                .setParameter("model", model)
                .getResultList();
    }
}
