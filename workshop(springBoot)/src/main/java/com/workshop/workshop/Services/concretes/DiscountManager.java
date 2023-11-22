package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.DiscountService;
import com.workshop.workshop.Services.dto.brand.requests.Discount.AddDiscountRequest;
import com.workshop.workshop.Services.dto.brand.requests.Discount.UpdateDiscountRequest;
import com.workshop.workshop.entities.Discount;
import com.workshop.workshop.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountManager implements DiscountService {

    private DiscountRepository discountRepository;

    @Autowired
    public DiscountManager(DiscountRepository discountRepository){
        this.discountRepository=discountRepository;
    }

    @Override
    public void add(AddDiscountRequest request) {
        Discount discount = new Discount();
        discount.setDiscountType(request.getDiscountType());
        discount.setDiscountPercent(request.getDiscountPercent());
        discountRepository.save(discount);
    }

    @Override
    public void update(UpdateDiscountRequest request, int id) {
        Discount existingDiscount = discountRepository.findById(id).orElseThrow();
        existingDiscount.setDiscountPercent(request.getDiscountPercent());
        existingDiscount.setDiscountType(request.getDiscountType());
        discountRepository.save(existingDiscount);

    }

    @Override
    public void delete(int id) {

        discountRepository.deleteById(id);

    }
}
