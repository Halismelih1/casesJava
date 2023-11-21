package com.workshop.workshop.repositories;

import com.workshop.workshop.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer>
{
}
