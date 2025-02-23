package com.example.CarAPI.services;

import com.example.CarAPI.dtos.brand.BrandCreateDto;
import com.example.CarAPI.dtos.brand.BrandDto;
import com.example.CarAPI.dtos.brand.BrandGetUpdateDto;
import com.example.CarAPI.dtos.brand.BrandUpdateDto;
import com.example.CarAPI.models.Brand;
import com.example.CarAPI.payloads.ApiPayload;

import java.util.List;

public interface BrandService {

    List<BrandDto> getAll();

    Brand findBrandById(Long id);

    ApiPayload create(BrandCreateDto brandCreateDto);

    BrandGetUpdateDto getUpdatedBrand(Long id);

    ApiPayload update(Long id, BrandUpdateDto brandUpdateDto);

    ApiPayload delete(Long id);
}
