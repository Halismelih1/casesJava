package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.BrandService;
import com.workshop.workshop.Services.dto.requests.Brand.AddBrandRequest;
import com.workshop.workshop.Services.dto.requests.Brand.UpdateBrandRequest;
import com.workshop.workshop.Services.dto.responses.Brand.BrandResponse;
import com.workshop.workshop.entities.Brand;
import com.workshop.workshop.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
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

    //TODO : StreamApi Used


    //public List<BrandResponse> getByBrandName(String brandName) {
    //return brandRepository.findByBrandName(brandName);

    public List<BrandResponse> getByBrandName(String brandName) {
        List<BrandResponse> brandList = brandRepository.findByBrandName(brandName);

        return brandList.stream()
                .map(brand -> new BrandResponse(brand.getId(), brand.getBrandName(), brand.getContractedGasStation()))
                .collect(Collectors.toList());

    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}
