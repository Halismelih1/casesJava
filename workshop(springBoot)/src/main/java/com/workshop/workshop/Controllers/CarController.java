package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.CarService;
import com.workshop.workshop.Services.dto.brand.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.brand.requests.Car.UpdateCarRequest;
import com.workshop.workshop.entities.Car;
import com.workshop.workshop.entities.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car") //http://localhost:8080/car
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }
    @GetMapping("byBrandId/{brandId}")
    public ResponseEntity <List<Car>> getByBrandId(@RequestParam("brandId") int brandId) {
        List<Car> cars = carService.getByBrandId(brandId);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byAvailable/{available}")
    public ResponseEntity<List<Car>> getByAvailable(@RequestParam boolean available) {
        List<Car> cars = carService.getByAvailable(available);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byModelJPQL/{model}")
    public ResponseEntity<List<Car>> getByModelJPQL(@PathVariable String model) {
        List<Car> cars = carService.findByModelJPQL(model);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
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



