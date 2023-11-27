package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.BrandService;
import com.workshop.workshop.Services.dto.brand.requests.Brand.AddBrandRequest;
import com.workshop.workshop.Services.dto.brand.requests.Brand.UpdateBrandRequest;
import com.workshop.workshop.entities.Brand;
import com.workshop.workshop.entities.Reservation;
import com.workshop.workshop.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    @Autowired
    public BrandManager(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }


    @Override
    public void add(AddBrandRequest request) {

        Brand brand = new Brand();
        brand.setBrandName(request.getBrandName());
        brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public void update(int id, UpdateBrandRequest request) {
        Brand existingBrand = brandRepository.findById(id).orElseThrow();
        existingBrand.setBrandName(request.getBrandName());
        brandRepository.save(existingBrand);
    }

    @Override
    public List<Brand> getByBrandName(String brandName) {
        List<Brand> brands = new ArrayList<>();
        Brand brand = brandRepository.findByBrandName(brandName);
        if (brand != null) {
            brands.add(brand);
        }
        return brands;
    }
    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}
