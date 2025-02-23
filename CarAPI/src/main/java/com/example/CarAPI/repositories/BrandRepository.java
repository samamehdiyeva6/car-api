package com.example.CarAPI.repositories;

import com.example.CarAPI.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
