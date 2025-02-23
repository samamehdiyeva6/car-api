package com.example.CarAPI.dtos.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandGetUpdateDto {
    private Long id;
    private String name;
}
