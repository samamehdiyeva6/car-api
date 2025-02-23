package com.example.CarAPI.dtos.model;

import com.example.CarAPI.dtos.brand.BrandDto;
import com.example.CarAPI.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelCreateDto {
    private String name;
    private Long brandId;
}
