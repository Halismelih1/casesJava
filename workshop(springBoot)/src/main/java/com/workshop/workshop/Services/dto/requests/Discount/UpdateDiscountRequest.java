package com.workshop.workshop.Services.dto.requests.Discount;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateDiscountRequest {
    private int id;
    @NotBlank(message = "discountType cannot be blank")
    private String discountType;
    @NotBlank(message = "discountPercent cannot be blank")
    private int discountPercent;
}
