package com.workshop.workshop.Controllers;

import com.workshop.workshop.entities.Brand;
import com.workshop.workshop.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand") //http://localhost:8080/brand
public class BrandController {
    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping
    public List<Brand> getAll(){
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){
        return brandRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Brand brandToDelete = brandRepository.findById(id)
                .orElseThrow();
        brandRepository.delete(brandToDelete);
    }
}
