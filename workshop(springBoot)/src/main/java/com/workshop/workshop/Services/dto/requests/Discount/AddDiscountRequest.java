package com.workshop.workshop.Services.dto.requests.Discount;


import lombok.Data;

@Data
public class AddDiscountRequest {

    private String discountType;
    private int discountPercent;
}
