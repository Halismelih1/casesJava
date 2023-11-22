package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Brand.AddBrandRequest;
import com.workshop.workshop.Services.dto.brand.requests.Brand.UpdateBrandRequest;

public interface BrandService {
    void add(AddBrandRequest request);
    void delete(int id);
    void update(int id, UpdateBrandRequest request);
}
