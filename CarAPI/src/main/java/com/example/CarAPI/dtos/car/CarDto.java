package com.example.CarAPI.dtos.car;

import com.example.CarAPI.dtos.photo.PhotoDto;
import com.example.CarAPI.models.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String photo;

}
