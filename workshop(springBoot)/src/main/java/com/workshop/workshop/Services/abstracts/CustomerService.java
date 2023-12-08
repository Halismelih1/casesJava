package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.requests.Customer.AddCustomerRequest;
import com.workshop.workshop.Services.dto.requests.Customer.UpdateCustomerRequest;
import com.workshop.workshop.Services.dto.responses.Customer.CustomerResponse;
import com.workshop.workshop.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();
    List<CustomerResponse> getByFirstNameUsingJPQL(String firstName);
    List<Customer> getByAdress(String adress);
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request, int id);
    List<Customer> delete(int id);
}
