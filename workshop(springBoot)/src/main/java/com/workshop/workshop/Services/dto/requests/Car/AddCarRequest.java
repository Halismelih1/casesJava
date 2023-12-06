package com.workshop.workshop.Services.dto.requests.Car;

import com.workshop.workshop.entities.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddCarRequest {
    private int id;
    @NotNull(message = "Brand cannot be null")
    private Brand brand;
    @NotNull(message = "Available status cannot be null")
    private Boolean available;
    @NotBlank(message = "Model cannot be blank")
    private String model;
}