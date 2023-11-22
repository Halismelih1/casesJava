package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.DiscountService;
import com.workshop.workshop.Services.dto.brand.requests.AddDiscountRequest;
import com.workshop.workshop.Services.dto.brand.requests.UpdateDiscountRequest;
import com.workshop.workshop.entities.Discount;
import com.workshop.workshop.entities.Reservation;
import com.workshop.workshop.repositories.DiscountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/discount")

public class DiscountController {
    private final DiscountService discountService;
    public DiscountController(DiscountService discountService){this.discountService = discountService; }


    @PostMapping
    public void add(@RequestBody AddDiscountRequest request){
        discountService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        discountService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateDiscountRequest request){
      discountService.update(request, id);
    }

    //@GetMapping
    //public List<Discount> getAll(){
        //List<Discount> discounts = discountRepository.findAll();
        //return discounts;
    //}
    //@GetMapping("{id}")
    //public Discount getbyId(@PathVariable int id){
        //return discountRepository.findById(id).orElseThrow();
    //}


}
