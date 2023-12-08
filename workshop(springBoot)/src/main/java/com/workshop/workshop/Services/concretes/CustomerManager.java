package com.workshop.workshop.Services.concretes;

import com.workshop.workshop.Services.abstracts.CustomerService;
import com.workshop.workshop.Services.dto.requests.Customer.AddCustomerRequest;
import com.workshop.workshop.Services.dto.requests.Customer.UpdateCustomerRequest;
import com.workshop.workshop.Services.dto.responses.Customer.CustomerResponse;
import com.workshop.workshop.entities.Customer;
import com.workshop.workshop.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAdress(request.getAdress());

        applyBusinessRulesCustomer(customer);

        customerRepository.save(customer);
    }

    // İş kuralları
    private void applyBusinessRulesCustomer(Customer customer) {

        // Email boş olmamalı ve belirli bir formatta olmalı
        if (customer.getEmail() != null && !customer.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalStateException("Invalid email format");
        }

        // Telefon numarası boş olmamalı ve belirli bir formatta olmalı
        if (customer.getPhone() != null && !customer.getPhone().matches("\\d{10}")) {
            throw new IllegalStateException("Phone number must be 10 digits");
        }
    }

    @Override
    public void update(UpdateCustomerRequest request, int id) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow();

        existingCustomer.setFirstName(request.getFirstName());
        existingCustomer.setLastName(request.getLastName());
        existingCustomer.setEmail(request.getEmail());
        existingCustomer.setPhone(request.getPhone());
        existingCustomer.setAdress(request.getAdress());

        customerRepository.save(existingCustomer);
    }

    @Override
    public List<Customer> delete(int id) {

        customerRepository.deleteById(id);

        return null;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


    @Override
    //TODO : StreamApi Used

    public List<CustomerResponse> getByFirstNameUsingJPQL(String firstName) {
        return customerRepository.findByFirstNameUsingJPQL(firstName).stream()
                .map(customer -> new CustomerResponse(
                        customer.getId(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail(),
                        customer.getPhone(),
                        customer.getAdress()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getByAdress(String adress) {
        return customerRepository.findByAdress(adress);
    }
}
