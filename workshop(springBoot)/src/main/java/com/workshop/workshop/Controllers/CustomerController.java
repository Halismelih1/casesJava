package com.workshop.workshop.Controllers;

import com.workshop.workshop.Services.abstracts.CustomerService;
import com.workshop.workshop.Services.dto.requests.Customer.AddCustomerRequest;
import com.workshop.workshop.Services.dto.requests.Customer.UpdateCustomerRequest;
import com.workshop.workshop.Services.dto.responses.Customer.CustomerResponse;
import com.workshop.workshop.entities.Customer;
import org.springframework.http.ResponseEntity;
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
    public List<CustomerResponse> getByFirstNameUsingJPQL(@RequestParam String firstName) {
        return customerService.getByFirstNameUsingJPQL(firstName);
    }

    @GetMapping("/byAdress")
    public List<Customer> getByAdress(@RequestParam String adress) {
        return customerService.getByAdress(adress);
    }

    @PostMapping // Add
    public ResponseEntity<Object> add(@RequestBody AddCustomerRequest request) {
        try {
            customerService.add(request);
            return ResponseEntity.ok("Customer added successfully.");
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping("{id}") //Delete
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }

    @PutMapping("{id}") // Update
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody UpdateCustomerRequest request) {
        try {
            customerService.update(request, id);
            return ResponseEntity.ok("Customer with ID " + id + " updated successfully.");
        } catch (IllegalAccessError e) {
            throw e;
        }
    }
}



