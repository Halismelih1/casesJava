package com.workshop.workshop.Services.dto.brand.requests;


import lombok.Data;

@Data
public class AddDiscountRequest {

    private String discountType;
    private int discountPercent;
}
