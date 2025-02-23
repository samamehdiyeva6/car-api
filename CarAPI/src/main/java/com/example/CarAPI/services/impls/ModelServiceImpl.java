package com.example.CarAPI.services.impls;

import com.example.CarAPI.dtos.model.ModelCreateDto;
import com.example.CarAPI.dtos.model.ModelDto;
import com.example.CarAPI.dtos.model.ModelGetUpdateDto;
import com.example.CarAPI.dtos.model.ModelUpdateDto;
import com.example.CarAPI.exceptions.ResourceNotFoundException;
import com.example.CarAPI.models.Brand;
import com.example.CarAPI.models.Model;
import com.example.CarAPI.payloads.ApiPayload;
import com.example.CarAPI.repositories.ModelRepository;
import com.example.CarAPI.services.BrandService;
import com.example.CarAPI.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final BrandService brandService;

    @Override
    public List<ModelDto> getAllModels() {
        List<Model> models = modelRepository.findAll();
        return models.stream().map(m->modelMapper.map(m, ModelDto.class)).toList();
    }

    @Override
    public ApiPayload create(ModelCreateDto modelCreateDto) {
        try{
            Brand brand = brandService.findBrandById(modelCreateDto.getBrandId());
            Model model = new Model();
            model.setName(modelCreateDto.getName());
            model.setBrand(brand);
            modelRepository.save(model);
            return new ApiPayload(true,"Model created successfully", HttpStatus.CREATED);

        }catch (Exception e){
            return new ApiPayload(false,e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ModelGetUpdateDto getUpdatedModel(Long id) {
        Model updateModel = modelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Model","id",id));
        return modelMapper.map(updateModel, ModelGetUpdateDto.class);
    }

    @Override
    public ApiPayload updateModel(Long id, ModelUpdateDto modelUpdateDto) {
        try{
            Brand brand = brandService.findBrandById(modelUpdateDto.getBrandId());
            Model findModel = modelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Model","id",id));
            findModel.setName(modelUpdateDto.getName());
            findModel.setBrand(brand);
            modelRepository.save(findModel);

            return new ApiPayload(true, "Model updated successfully", HttpStatus.OK);

        }catch (Exception e){
            return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ApiPayload deleteModel(Long id) {
        try{
            Model findModel = modelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Model","id",id));
            modelRepository.delete(findModel);
            return new ApiPayload(true, "Model was deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ApiPayload(false, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
