package com.techphantomexample.nurseryproject.controller;
import com.techphantomexample.nurseryproject.model.Plant;
import com.techphantomexample.nurseryproject.services.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController
{
    PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping
    public ResponseEntity<CreateResponse> createPlant(@RequestBody Plant plant) {
        String result = plantService.createPlant(plant);
        HttpStatus httpStatus = null;
        if (result.equals("Plant Created successfully")) {
            httpStatus = HttpStatus.CREATED;
        } else  if (result.equals("Plant Already Created")) {
            httpStatus = HttpStatus.CONFLICT;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }

    // Read all users in DB
    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlantDetails() {
        List<Plant> plants = plantService.getAllPlants();
        return ResponseEntity.ok().body(plants);
    }
    // Read specific user
    @GetMapping("{plantId}")
    public ResponseEntity<Plant> getPlantDetails(@PathVariable("plantId") int plantId) {
        Plant plant = plantService.getPlant(plantId);
        if (plant != null) {
            return ResponseEntity.ok().body(plant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
