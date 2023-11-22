package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.CustomerService;
import com.workshop.workshop.Services.dto.brand.requests.Customer.AddCustomerRequest;
import com.workshop.workshop.Services.dto.brand.requests.Customer.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer") //http://localhost:8080/customer

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){this.customerService = customerService; }

    @PostMapping //Add
    public void add(@RequestBody AddCustomerRequest request) {
        customerService.add(request);
    }

    @DeleteMapping("{id}") //Delete
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }

    @PutMapping("{id}") //Update
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest request) {
        customerService.update(request, id);
    }
}

    //@GetMapping
    //public List<Customer> getAll(){
        //List<Customer> customers = customerRepository.findAll();
        //return customers;
    //}

    //@GetMapping("{id}")
    //public Customer getById(@PathVariable int id){
        //return customerRepository.findById(id).orElseThrow();
    //}


