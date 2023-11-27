package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.BrandService;
import com.workshop.workshop.Services.dto.brand.requests.Brand.AddBrandRequest;
import com.workshop.workshop.Services.dto.brand.requests.Brand.UpdateBrandRequest;
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

    @GetMapping("/byBrandName/{brandName}")
    public ResponseEntity <List<Brand>> getByBrandName(@RequestParam("brandName")String brandName){
        List<Brand> brands = brandService.getByBrandName(brandName);
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
    }
}

    // @GetMapping
    //public List<Brand> getAll(){
       // List<Brand> brands = brandRepository.findAll();
        //return brands;
    //}

    // @GetMapping("{id}")
    //public Brand getById(@PathVariable int id){
        //return brandRepository.findById(id)
                //.orElseThrow();
    //}



    //@DeleteMapping("{id}")
    //public void delete(@PathVariable int id){
        //Brand brandToDelete = brandRepository.findById(id)
            //    .orElseThrow();
        //brandRepository.delete(brandToDelete);
    //}

    //@PutMapping("{id}")
    //public void update(@RequestBody Brand updatedBrand,@PathVariable int id){
        //Brand brandToUpdate = brandRepository.findById(id).orElseThrow();
        //brandToUpdate.setBrandName(updatedBrand.getBrandName());
        //brandRepository.save(brandToUpdate);
    //}

