package com.workshop.workshop.Services.dto.requests.Brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateBrandRequest {
    private int id;
    @Size(max = 15, message = "brandName length must be at most 15 characters")
    @NotNull
    @NotBlank(message = "brandname cannot be blank")
    private String brandName;
}
