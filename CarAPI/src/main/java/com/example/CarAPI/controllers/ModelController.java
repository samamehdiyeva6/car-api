package com.example.CarAPI.controllers;

import com.example.CarAPI.dtos.model.ModelCreateDto;
import com.example.CarAPI.dtos.model.ModelDto;
import com.example.CarAPI.dtos.model.ModelGetUpdateDto;
import com.example.CarAPI.dtos.model.ModelUpdateDto;
import com.example.CarAPI.payloads.ApiPayload;
import com.example.CarAPI.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;


    @GetMapping("/getAll")
    public ResponseEntity<List<ModelDto>> getAll(){
        List<ModelDto> models = modelService.getAllModels();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiPayload> create(@RequestBody ModelCreateDto modelCreateDto){
        ApiPayload response = modelService.create(modelCreateDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<ModelGetUpdateDto> getUpdateModel(@PathVariable Long id){
        ModelGetUpdateDto updatedModel = modelService.getUpdatedModel(id);
        return new ResponseEntity<>(updatedModel, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiPayload> update(@PathVariable Long id, ModelUpdateDto modelUpdateDto){
        ApiPayload response = modelService.updateModel(id, modelUpdateDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiPayload> delete(@PathVariable Long id){
        ApiPayload response = modelService.deleteModel(id);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }


}
