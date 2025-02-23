package com.example.CarAPI.services.impls;

import com.example.CarAPI.dtos.car.CarDetailDto;
import com.example.CarAPI.dtos.car.CarDto;
import com.example.CarAPI.models.Car;
import com.example.CarAPI.repositories.CarRepository;
import com.example.CarAPI.services.CarService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<CarDto> getAllCars() {
        List<Car> findCars =  carRepository.findAll();
        List<CarDto> cars = findCars.stream().map(c-> modelMapper.map(c, CarDto.class)).toList();
        cars.forEach(c->{
            String car = findCars.stream().flatMap(a->a.getPhotos().stream()).findFirst().get().getUrl();
            c.setPhoto(car);
        });
        return cars;
    }

    @Override
    public CarDetailDto getCarDetail(Long id) {
        Car findCar = carRepository.findById(id).orElseThrow();
        return modelMapper.map(findCar, CarDetailDto.class);
    }
}
