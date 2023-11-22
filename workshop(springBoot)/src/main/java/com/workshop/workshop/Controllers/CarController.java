package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.CarService;
import com.workshop.workshop.Services.dto.brand.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.brand.requests.Car.UpdateCarRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car") //http://localhost:8080/car
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request) {
        carService.add(request);
    }

    @DeleteMapping("{id}") //Delete
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }

    @PutMapping("{id}") //Update
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest request) {
        carService.update(id, request);
    }


}


    //@DeleteMapping("{id}")
    //public void delete(@PathVariable int id) {
        //Car carToDelete = carRepository.findById(id).orElseThrow();
        //carRepository.delete(carToDelete);




    //@PutMapping("{id}")
   // public void update(@RequestBody Car updatedCar,@PathVariable int id){
       // Car carToUpdate = carRepository.findById(id).orElseThrow();
        //carToUpdate.setModel(updatedCar.getModel());
        //carToUpdate.setAvailable(updatedCar.getAvailable());
        //carRepository.save(carToUpdate);
   // }



    //@GetMapping
    //public List<Car> getAll(){
        //List<Car> cars = carRepository.findAll();
        //return cars;
    //}

    //@GetMapping("{id}")
    //public Car getById(@PathVariable int id){
        //return carRepository.findById(id).orElseThrow();



