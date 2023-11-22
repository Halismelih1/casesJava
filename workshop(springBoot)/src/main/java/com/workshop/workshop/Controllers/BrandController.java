package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.BrandService;
import com.workshop.workshop.Services.dto.brand.requests.AddBrandRequest;
import com.workshop.workshop.Services.dto.brand.requests.UpdateBrandRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand") //http://localhost:8080/brand
public class BrandController {
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
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

