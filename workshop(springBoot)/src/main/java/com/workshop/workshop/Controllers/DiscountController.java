package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.DiscountService;
import com.workshop.workshop.Services.dto.brand.requests.Discount.AddDiscountRequest;
import com.workshop.workshop.Services.dto.brand.requests.Discount.UpdateDiscountRequest;
import com.workshop.workshop.entities.Discount;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/discount")

public class DiscountController {
    private final DiscountService discountService;
    public DiscountController(DiscountService discountService){this.discountService = discountService; }

    @GetMapping
    public List<Discount> getAllDiscounts() {
        return discountService.getAll();
    }

    @GetMapping("/byPercentRange")
    public List<Discount> getByDiscountPercentRange(@RequestParam int minPercent, @RequestParam int maxPercent) {
        return discountService.getByDiscountPercentRange(minPercent, maxPercent);
    }

    @GetMapping("/byType")
    public List<Discount> getByDiscountType(@RequestParam String discountType) {
        return discountService.getByDiscountType(discountType);
    }


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




}
