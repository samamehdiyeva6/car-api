package com.example.CarAPI.controllers;

import com.example.CarAPI.dtos.brand.BrandCreateDto;
import com.example.CarAPI.dtos.brand.BrandDto;
import com.example.CarAPI.dtos.brand.BrandGetUpdateDto;
import com.example.CarAPI.dtos.brand.BrandUpdateDto;
import com.example.CarAPI.payloads.ApiPayload;
import com.example.CarAPI.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand/")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BrandDto>> getAll(){
        List<BrandDto> brands = brandService.getAll();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiPayload> create(@RequestBody BrandCreateDto brandCreateDto){
        ApiPayload response = brandService.create(brandCreateDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }


    @GetMapping("/getUpdate/{id}")
    public ResponseEntity<BrandGetUpdateDto> getUpdatedBrand(@PathVariable Long id){
        BrandGetUpdateDto brand = brandService.getUpdatedBrand(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PutMapping("/getUpdate/{id}")
    public ResponseEntity<ApiPayload> update(@PathVariable Long id, @RequestBody BrandUpdateDto brandUpdateDto){
        ApiPayload response = brandService.update(id, brandUpdateDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiPayload> delete(@PathVariable Long id){
        ApiPayload response = brandService.delete(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
