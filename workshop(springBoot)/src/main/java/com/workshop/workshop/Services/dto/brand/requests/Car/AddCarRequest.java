package com.workshop.workshop.Services.dto.brand.requests.Car;

import com.workshop.workshop.entities.Brand;
import lombok.Data;

@Data
public class AddCarRequest {
    private int id;
    private Brand brand;
    private Boolean available;
    private String model;
}
