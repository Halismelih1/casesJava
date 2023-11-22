package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Discount.AddDiscountRequest;
import com.workshop.workshop.Services.dto.brand.requests.Discount.UpdateDiscountRequest;

public interface DiscountService {
    void add(AddDiscountRequest request);
    void update(UpdateDiscountRequest request, int id);
    void delete(int id);
}
