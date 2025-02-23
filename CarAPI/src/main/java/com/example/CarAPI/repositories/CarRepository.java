package com.example.CarAPI.repositories;

import com.example.CarAPI.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
