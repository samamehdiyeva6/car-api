package com.example.CarAPI.dtos.model;

import com.example.CarAPI.dtos.brand.BrandDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelGetUpdateDto {
    private String name;
    private BrandDto brand;
}
