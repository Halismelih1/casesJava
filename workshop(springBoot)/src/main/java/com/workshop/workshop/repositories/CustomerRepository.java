package com.workshop.workshop.repositories;

import com.workshop.workshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByFirstName(String firstName);

    @Query("SELECT c FROM Customer c WHERE c.firstName = :firstName")
    List<Customer> findByFirstNameUsingJPQL(@Param("firstName") String firstName);

    List<Customer> findByAdress(String adress);
}
