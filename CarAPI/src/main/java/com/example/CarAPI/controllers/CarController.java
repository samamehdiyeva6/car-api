package com.example.CarAPI.controllers;

import com.example.CarAPI.dtos.car.CarDetailDto;
import com.example.CarAPI.dtos.car.CarDto;
import com.example.CarAPI.models.Car;
import com.example.CarAPI.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CarDto>> getAll(){
        List<CarDto> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<CarDetailDto> getDetail(@PathVariable Long id){
        CarDetailDto car = carService.getCarDetail(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
}
