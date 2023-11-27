package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Discount.AddDiscountRequest;
import com.workshop.workshop.Services.dto.brand.requests.Discount.UpdateDiscountRequest;
import com.workshop.workshop.entities.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> getAll();
    List<Discount> getByDiscountPercentRange(int minPercent, int maxPercent);
    List<Discount> getByDiscountType(String discountType);
    void add(AddDiscountRequest request);
    void update(UpdateDiscountRequest request, int id);
    void delete(int id);
}
