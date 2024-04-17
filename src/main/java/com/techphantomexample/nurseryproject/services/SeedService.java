package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.Plant;
import com.techphantomexample.nurseryproject.model.Seed;

import java.util.List;

public interface SeedService {

    public String createSeed(Seed seed);
    public String updateSeed(int seedId ,Seed seed);
    public String deleteSeed(int seedId);
    public Seed getSeed(int seedId);
    public List<Seed> getAllSeed();
}
