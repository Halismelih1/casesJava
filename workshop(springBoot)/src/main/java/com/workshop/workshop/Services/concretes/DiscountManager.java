package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.DiscountService;
import com.workshop.workshop.Services.dto.requests.Discount.AddDiscountRequest;
import com.workshop.workshop.Services.dto.requests.Discount.UpdateDiscountRequest;
import com.workshop.workshop.Services.dto.responses.Discount.DiscountResponse;
import com.workshop.workshop.entities.Discount;
import com.workshop.workshop.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        throw new IllegalStateException("Geçersiz İşlem!");
    }



    @Override
    public void update(UpdateDiscountRequest request, int id) {
        Discount existingDiscount = discountRepository.findById(id).orElseThrow();
        existingDiscount.setDiscountPercent(request.getDiscountPercent());
        existingDiscount.setDiscountType(request.getDiscountType());

        if ("New Customer".equals(existingDiscount.getDiscountType()) &&
                (existingDiscount.getDiscountPercent() < 5 || existingDiscount.getDiscountPercent() > 15)) {
            throw new IllegalStateException("For New Customer discount type, discount percent must be between 5 and 15");
        }
        if ("First Rent".equals(existingDiscount.getDiscountType()) &&
                (existingDiscount.getDiscountPercent() < 10 || existingDiscount.getDiscountPercent() > 20)) {
            throw new IllegalStateException("For First Rent discount type, discount percent must be between 10 and 20");
        }
        discountRepository.save(existingDiscount);
    }

    @Override
    public void delete(int id) {
        discountRepository.deleteById(id);
        throw new IllegalStateException("lütfen geçerli bir id giriniz!");

    }

    @Override
    public List<Discount> getAll() {
        return discountRepository.findAll();
    }


    @Override
    //TODO : StreamApi Used
    public List<DiscountResponse> getByDiscountPercentRange(int minPercent, int maxPercent) {
        return discountRepository.findByDiscountPercentRange(minPercent, maxPercent)
                .stream()
                .map(discount -> new DiscountResponse(discount.getId(), discount.getDiscountType(), discount.getDiscountPercent()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Discount> getByDiscountType(String discountType) {
        return discountRepository.findByDiscountType(discountType);
    }
}
