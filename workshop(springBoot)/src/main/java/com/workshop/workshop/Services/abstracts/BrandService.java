package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.requests.Brand.AddBrandRequest;
import com.workshop.workshop.Services.dto.requests.Brand.UpdateBrandRequest;
import com.workshop.workshop.Services.dto.responses.Brand.BrandResponse;
import com.workshop.workshop.entities.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    List <BrandResponse>getByBrandName(String brandName);
    void add(AddBrandRequest request);
    void delete(int id);
    void update(int id, UpdateBrandRequest request);
}
