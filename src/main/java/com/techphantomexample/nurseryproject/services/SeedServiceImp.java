package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.Plant;
import com.techphantomexample.nurseryproject.model.Seed;
import com.techphantomexample.nurseryproject.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeedServiceImp implements  SeedService{

    @Autowired
    SeedRepository seedRepository;

    public SeedServiceImp(SeedRepository seedRepository) {
        this.seedRepository = seedRepository;
    }

    @Override
    public String createSeed(Seed seed) {
        String seedName = seed.getSeedName();

        if (seedName != null && existsBySeedName(seedName)) {
            return "Seed Already Created";
        }
        seedRepository.save(seed);
        return "Seed Created successfully";
    }

    private boolean existsBySeedName(String seedName) {
        return seedRepository.existsBySeedName(seedName);
    }

    @Override
    public String updateSeed(int seedId, Seed newSeedDetails) {
        Optional<Seed> optionalUser = seedRepository.findById(seedId);
        if (optionalUser.isPresent()) {
            Seed existingSeed = optionalUser.get();

            existingSeed.setSeedName(newSeedDetails.getSeedName());
            existingSeed.setSeedCategory(newSeedDetails.getSeedCategory());
            existingSeed.setSeedDesc(newSeedDetails.getSeedDesc());
            existingSeed.setSeedPackQuantity(newSeedDetails.getSeedPackQuantity());
            existingSeed.setSeedPrice(newSeedDetails.getSeedPrice());
            existingSeed.setSeedAvailability(newSeedDetails.isSeedAvailability());


            seedRepository.save(existingSeed);

            return "Seed updated successfully";
        } else {

            return "";
        }
    }

    @Override
    public String deleteSeed(int seedId) {
        if (seedRepository.existsById(seedId))
        {
            seedRepository.deleteById(seedId);
            return "Seed deleted successfully";
        }
        return "Seed not found";
    }

    @Override
    public Seed getSeed(int seedId) {
        return seedRepository.findById(seedId).get();
    }

    @Override
    public List<Seed> getAllSeed() {
        return seedRepository.findAll();
    }
}
