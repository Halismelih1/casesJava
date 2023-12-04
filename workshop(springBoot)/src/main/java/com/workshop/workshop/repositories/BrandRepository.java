package com.workshop.workshop.repositories;

import com.workshop.workshop.Services.dto.responses.Brand.BrandResponse;
import com.workshop.workshop.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    @Query("SELECT new com.workshop.workshop.Services.dto.responses.Brand.BrandResponse(b.id, b.brandName, b.contractedGasStation) FROM Brand b WHERE b.brandName = :brandName")
    List<BrandResponse> findByBrandName(@Param("brandName") String brandName);


}
