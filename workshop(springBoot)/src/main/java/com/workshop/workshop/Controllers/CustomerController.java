package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.CustomerService;
import com.workshop.workshop.Services.dto.brand.requests.Customer.AddCustomerRequest;
import com.workshop.workshop.Services.dto.brand.requests.Customer.UpdateCustomerRequest;
import com.workshop.workshop.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer") //http://localhost:8080/customer

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){this.customerService = customerService; }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/byFirstNameUsingJPQL")
    public List<Customer> getByFirstNameUsingJPQL(@RequestParam String firstName) {
        return customerService.getByFirstNameUsingJPQL(firstName);
    }

    @GetMapping("/byAdress")
    public List<Customer> getByAdress(@RequestParam String adress) {
        return customerService.getByAdress(adress);
    }

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




