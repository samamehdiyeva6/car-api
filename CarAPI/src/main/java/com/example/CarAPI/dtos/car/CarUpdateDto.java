package com.example.CarAPI.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarUpdateDto {
    private Long id;
    private String name;
}
