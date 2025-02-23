package com.example.CarAPI.services.impls;

import com.example.CarAPI.dtos.brand.BrandCreateDto;
import com.example.CarAPI.dtos.brand.BrandDto;
import com.example.CarAPI.dtos.brand.BrandGetUpdateDto;
import com.example.CarAPI.dtos.brand.BrandUpdateDto;
import com.example.CarAPI.exceptions.ResourceNotFoundException;
import com.example.CarAPI.models.Brand;
import com.example.CarAPI.payloads.ApiPayload;
import com.example.CarAPI.repositories.BrandRepository;
import com.example.CarAPI.services.BrandService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BrandDto> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(b->modelMapper.map(b, BrandDto.class)).toList();
    }

    @Override
    public Brand findBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Brand","id",id));
    }

    @Override
    public ApiPayload create(BrandCreateDto brandCreateDto) {
        try {
            Brand brand = new Brand();
            brand.setName(brandCreateDto.getName());
            brandRepository.save(brand);
            return new ApiPayload(true, "Brand created successfully", HttpStatus.CREATED);

        }catch (Exception e){
            return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public BrandGetUpdateDto getUpdatedBrand(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Brand","id",id));
        return modelMapper.map(brand, BrandGetUpdateDto.class);
    }

    @Override
    public ApiPayload update(Long id, BrandUpdateDto brandUpdateDto) {
        try{
            Brand updatedBrand = brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Brand","id",id));
            updatedBrand.setName(brandUpdateDto.getName());
            brandRepository.save(updatedBrand);
            return new ApiPayload(true, "Brand updated successfully", HttpStatus.OK);

        }catch (Exception e){
            return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ApiPayload delete(Long id) {
        try{
            brandRepository.deleteById(id);
            return new ApiPayload(true, "Deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
