package com.example.CarAPI.repositories;

import com.example.CarAPI.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
