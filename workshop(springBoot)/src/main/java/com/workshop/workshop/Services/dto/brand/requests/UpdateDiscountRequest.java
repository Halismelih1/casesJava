package com.workshop.workshop.Services.dto.brand.requests;

import lombok.Data;

@Data
public class UpdateDiscountRequest {
    private int id;
    private String discountType;
    private int discountPercent;
}
