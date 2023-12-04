package com.workshop.workshop.Services.dto.responses.Car;

import com.workshop.workshop.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponse {
    private int id;
    private String model;
    private Boolean available;
    private Brand brand;
}