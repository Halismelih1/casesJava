package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.requests.Discount.AddDiscountRequest;
import com.workshop.workshop.Services.dto.requests.Discount.UpdateDiscountRequest;
import com.workshop.workshop.Services.dto.responses.Discount.DiscountResponse;
import com.workshop.workshop.entities.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> getAll();
    List<DiscountResponse> getByDiscountPercentRange(int minPercent, int maxPercent);
    List<Discount> getByDiscountType(String discountType);
    void add(AddDiscountRequest request);
    void update(UpdateDiscountRequest request, int id);
    void delete(int id);
}
