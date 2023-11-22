package com.workshop.workshop.Services.abstracts;

import com.workshop.workshop.Services.dto.brand.requests.Customer.AddCustomerRequest;
import com.workshop.workshop.Services.dto.brand.requests.Customer.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void update(UpdateCustomerRequest request, int id);
    void delete(int id);
}
