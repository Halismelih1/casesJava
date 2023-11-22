package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.ReservationService;
import com.workshop.workshop.Services.dto.brand.requests.AddReservationRequest;
import com.workshop.workshop.Services.dto.brand.requests.UpdateReservationRequest;
import com.workshop.workshop.entities.Customer;
import com.workshop.workshop.entities.Reservation;
import com.workshop.workshop.repositories.CustomerRepository;
import com.workshop.workshop.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation") //http://localhost:8080/reservation

public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService)
    {this.reservationService = reservationService; }


    @PostMapping
    public void add(@RequestBody AddReservationRequest request){
        reservationService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        reservationService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateReservationRequest request){
        reservationService.update(id, request);
    }

    //@GetMapping
    //public List<Reservation> getAll(){
        //List<Reservation> reservations = reservationRepository.findAll();
        //return reservations;
    //}

    //@GetMapping("{id}")
    //public Reservation getById(@PathVariable int id){
        //return reservationRepository.findById(id).orElseThrow();
    //}


}
