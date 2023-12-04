package com.workshop.workshop.Services.dto.responses.Discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscountResponse {
    private int id;
    private String discountType;
    private int discountPercent;
}
