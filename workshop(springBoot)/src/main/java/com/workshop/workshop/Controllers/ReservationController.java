package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.ReservationService;
import com.workshop.workshop.Services.dto.requests.Reservation.AddReservationRequest;
import com.workshop.workshop.Services.dto.requests.Reservation.UpdateReservationRequest;
import com.workshop.workshop.Services.dto.responses.Reservation.ReservationResponse;
import com.workshop.workshop.entities.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation") //http://localhost:8080/reservation

public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService)
    {this.reservationService = reservationService; }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/byTotalPriceRange")
    public List<ReservationResponse> getByTotalPriceRange(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return reservationService.findByTotalPriceRange(minPrice, maxPrice);
    }

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




}
