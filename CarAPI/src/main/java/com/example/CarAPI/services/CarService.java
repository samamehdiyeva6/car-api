package com.example.CarAPI.services;

import com.example.CarAPI.dtos.car.CarDetailDto;
import com.example.CarAPI.dtos.car.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();

    CarDetailDto getCarDetail(Long id);
}
