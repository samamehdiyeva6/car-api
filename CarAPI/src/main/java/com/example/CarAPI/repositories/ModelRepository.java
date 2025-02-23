package com.example.CarAPI.repositories;

import com.example.CarAPI.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
