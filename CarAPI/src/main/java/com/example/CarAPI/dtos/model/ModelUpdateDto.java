package com.example.CarAPI.dtos.model;

import com.example.CarAPI.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelUpdateDto {
    private String name;
    private Long brandId;
}
