package com.example.CarAPI.dtos.car;

import com.example.CarAPI.dtos.photo.PhotoDto;
import com.example.CarAPI.models.Model;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailDto {
    private String name;
    private Double price;
    private Double discount;
    private String description;
    private List<PhotoDto> photos;
}
