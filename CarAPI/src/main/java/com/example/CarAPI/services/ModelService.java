package com.example.CarAPI.services;

import com.example.CarAPI.dtos.model.ModelCreateDto;
import com.example.CarAPI.dtos.model.ModelDto;
import com.example.CarAPI.dtos.model.ModelGetUpdateDto;
import com.example.CarAPI.dtos.model.ModelUpdateDto;
import com.example.CarAPI.payloads.ApiPayload;

import java.util.List;

public interface ModelService {
    List<ModelDto> getAllModels();

    ApiPayload create(ModelCreateDto modelCreateDto);

    ModelGetUpdateDto getUpdatedModel(Long id);

    ApiPayload updateModel(Long id, ModelUpdateDto modelUpdateDto);

    ApiPayload deleteModel(Long id);
}
