package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.AddBrandRequest;
import com.workshop.workshop.Services.dto.brand.requests.UpdateBrandRequest;

public interface BrandService {
    void add(AddBrandRequest request);
    void delete(int id);
    void update(int id, UpdateBrandRequest request);
}
