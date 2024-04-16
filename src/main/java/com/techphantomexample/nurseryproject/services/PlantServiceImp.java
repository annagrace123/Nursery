package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.Plant;
import com.techphantomexample.nurseryproject.model.User;
import com.techphantomexample.nurseryproject.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImp implements  PlantService{

    @Autowired
    PlantRepository plantRepository;

    public PlantServiceImp(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public String createPlant(Plant plant) {
        String plantName = plant.getPlantName();
        
        if (plantName != null && existsByPlantName(plantName)) {
            return "Plant Already Created";
        }
        plantRepository.save(plant);
        return "Plant Created successfully";
    }
    
    private boolean existsByPlantName(String plantName) {
        return plantRepository.existsByPlantName(plantName);
    }

    @Override
    public String updatePlant(int plantId, Plant newPlantDetails) {
        Optional<Plant> optionalUser = plantRepository.findById(plantId);
        if (optionalUser.isPresent()) {
            Plant existingPlant = optionalUser.get();

            existingPlant.setPlantName(newPlantDetails.getPlantName());
            existingPlant.setPlantCategory(newPlantDetails.getPlantCategory());
            existingPlant.setPlantDesc(newPlantDetails.getPlantDesc());
            existingPlant.setPlantQuantity(newPlantDetails.getPlantQuantity());
            existingPlant.setPlantPrice(newPlantDetails.getPlantPrice());
            existingPlant.setPlantAvailability(newPlantDetails.isPlantAvailability());


            plantRepository.save(existingPlant);

            return "Plant updated successfully";
        } else {

            return "";
        }
    }

    @Override
    public String deletePlant(int plantId) {
        if (plantRepository.existsById(plantId))
        {
            plantRepository.deleteById(plantId);
            return "Plant deleted successfully";
        }
        return "Plant not found";
    }

    @Override
    public Plant getPlant(int plantId) {
        return plantRepository.findById(plantId).get();
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }
}
