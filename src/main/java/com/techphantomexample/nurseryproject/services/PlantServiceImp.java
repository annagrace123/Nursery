package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.Plant;
import com.techphantomexample.nurseryproject.repository.PlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImp implements  PlantService{


    PlantRepository plantRepository;

    public PlantServiceImp(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public String createPlant(Plant plant) {
        String plantName = plant.getPlantName();
        if (plantName != null && existsByName(plantName)) {
            return "Plant Already Created";
        }
        plantRepository.save(plant);
        return "Plant Created successfully";
    }
    private boolean existsByName(String plantName) {
        return PlantRepository.existsByName(plantName);
    }

    @Override
    public boolean updatePlant(int plantId, Plant plant) {
        return false;
    }

    @Override
    public boolean deletePlant(int plantId) {
        return false;
    }

    @Override
    public Plant getPlant(int plantId) {
        return null;
    }

    @Override
    public List<Plant> getAllPlants() {
        return List.of();
    }
}
