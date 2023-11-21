package com.workshop.workshop.Controllers;

import com.workshop.workshop.entities.Discount;
import com.workshop.workshop.entities.Reservation;
import com.workshop.workshop.repositories.DiscountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/discount")

public class DiscountController {
    private final DiscountRepository discountRepository;
    public DiscountController(DiscountRepository discountRepository){this.discountRepository = discountRepository; }

    @GetMapping
    public List<Discount> getAll(){
        List<Discount> discounts = discountRepository.findAll();
        return discounts;
    }
    @GetMapping("{id}")
    public Discount getbyId(@PathVariable int id){
        return discountRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Discount discount){
        discountRepository.save(discount);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Discount discountToDelete = discountRepository.findById(id).orElseThrow();
        discountRepository.delete(discountToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Discount updatedDiscount){
        Discount discountToUpdate = discountRepository.findById(id).orElseThrow();
        discountToUpdate.setDiscountPercent(updatedDiscount.getDiscountPercent());
        discountToUpdate.setDiscountType(updatedDiscount.getDiscountType());
        discountRepository.save(discountToUpdate);
    }
}
