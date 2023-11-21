package com.workshop.workshop.Controllers;

import com.workshop.workshop.entities.Customer;
import com.workshop.workshop.entities.Reservation;
import com.workshop.workshop.repositories.CustomerRepository;
import com.workshop.workshop.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation") //http://localhost:8080/reservation

public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository){this.reservationRepository = reservationRepository; }

    @GetMapping
    public List<Reservation> getAll(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    @GetMapping("{id}")
    public Reservation getById(@PathVariable int id){
        return reservationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(reservationToDelete);
    }
}
