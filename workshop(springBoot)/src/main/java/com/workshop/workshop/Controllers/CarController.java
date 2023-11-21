package com.workshop.workshop.Controllers;

import com.workshop.workshop.entities.Car;
import com.workshop.workshop.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car") //http://localhost:8080/car
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car){
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("{id}")
     public void update(@RequestBody Car updatedCar,@PathVariable int id){
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setModel(updatedCar.getModel());
        carToUpdate.setAvailable(updatedCar.getAvailable());
        carRepository.save(carToUpdate);
    }

}
