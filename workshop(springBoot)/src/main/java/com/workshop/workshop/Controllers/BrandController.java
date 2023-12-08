package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.BrandService;
import com.workshop.workshop.Services.dto.requests.Brand.AddBrandRequest;
import com.workshop.workshop.Services.dto.requests.Brand.UpdateBrandRequest;
import com.workshop.workshop.Services.dto.responses.Brand.BrandResponse;
import com.workshop.workshop.entities.Brand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand") //http://localhost:8080/brand
public class BrandController {
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{brandName}")
    public ResponseEntity <List<BrandResponse>> getByBrandName(@RequestParam("brandName")String brandName){
        List<BrandResponse> brands = brandService.getByBrandName(brandName);
        if (!brands.isEmpty()) {
            return ResponseEntity.ok(brands);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping //Add
    public void add(@RequestBody AddBrandRequest request) {
        brandService.add(request);
    }

    @DeleteMapping("{id}") //Delete
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

    @PutMapping("{id}") //Update
    public void update(@PathVariable int id, @RequestBody UpdateBrandRequest request) {
        brandService.update(id, request);
        throw new IllegalStateException("deneme");

    }
}



