package com.workshop.workshop.repositories;

import com.workshop.workshop.Services.dto.responses.Customer.CustomerResponse;
import com.workshop.workshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT new com.workshop.workshop.Services.dto.responses.Customer.CustomerResponse(c.id, c.firstName, c.lastName, c.email, c.phone, c.adress) FROM Customer c WHERE c.firstName = :firstName")
    List<CustomerResponse> findByFirstNameUsingJPQL(@Param("firstName") String firstName);

    List<Customer> findByAdress(String adress);
}
