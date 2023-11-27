package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Customer.AddCustomerRequest;
import com.workshop.workshop.Services.dto.brand.requests.Customer.UpdateCustomerRequest;
import com.workshop.workshop.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    List<Customer> getByFirstNameUsingJPQL(String firstName);
    List<Customer> getByAdress(String adress);
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request, int id);
    void delete(int id);
}
