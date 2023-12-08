package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.CarService;
import com.workshop.workshop.Services.dto.requests.Car.AddCarRequest;
import com.workshop.workshop.Services.dto.responses.Car.CarResponse;
import com.workshop.workshop.Services.dto.requests.Car.UpdateCarRequest;
import com.workshop.workshop.entities.Car;
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
    @GetMapping("/byBrandId/{brandId}")
    public ResponseEntity <List<Car>> getByBrandId(@RequestParam("brandId") int brandId) {
        List<Car> cars = carService.getByBrandId(brandId);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byAvailable/{available}")
    public ResponseEntity<List<Car>> getByAvailable(@PathVariable boolean available) {
        List<Car> cars = carService.getByAvailable(available);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byModelJPQL")
    public List<CarResponse> getByModelJPQL(@RequestParam String model) {
        return carService.findByModelJPQL(model);
    }


    @PostMapping
    public void add(@RequestBody AddCarRequest request) {
        try {
            carService.add(request);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @DeleteMapping("{id}") //Delete
    public void delete(@PathVariable int id) {
        carService.delete(id);
        throw new IllegalStateException("yanlış id ile silme");
    }

    @PutMapping("{id}") //Update
    public void update(@PathVariable int id, @RequestBody UpdateCarRequest request) {
        carService.update(id, request);
        throw new IllegalStateException("yanlış id ile güncelleme");
    }
}



