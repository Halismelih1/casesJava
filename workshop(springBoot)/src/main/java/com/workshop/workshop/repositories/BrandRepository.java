package com.workshop.workshop.repositories;

import com.workshop.workshop.entities.Brand;
import com.workshop.workshop.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    <List>Brand findByBrandName(String brandName);
    List<Brand> findAll();

}
