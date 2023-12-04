package com.workshop.workshop.Services.dto.responses.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandResponse {
    private int id;
    private String brandName;
    private String contractedGasStation;

}
