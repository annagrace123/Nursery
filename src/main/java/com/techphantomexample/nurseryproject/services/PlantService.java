package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.Plant;

import java.util.List;

public interface PlantService
{
    public String createPlant(Plant plant);
    public boolean updatePlant(int plantId ,Plant plant);
    public boolean deletePlant(int plantId);
    public Plant getPlant(int plantId);
    public List<Plant> getAllPlants();
}
