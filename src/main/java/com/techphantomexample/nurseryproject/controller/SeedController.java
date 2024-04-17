package com.techphantomexample.nurseryproject.controller;

import com.techphantomexample.nurseryproject.model.Plant;
import com.techphantomexample.nurseryproject.model.Seed;
import com.techphantomexample.nurseryproject.services.SeedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seed")
public class SeedController
{
    SeedService seedService;

    public SeedController(SeedService seedService) {
        this.seedService = seedService;
    }

    @PostMapping
    public ResponseEntity<CreateResponse> createSeed(@RequestBody Seed seed) {
        String result = seedService.createSeed(seed);
        HttpStatus httpStatus = null;
        if (result.equals("Seed Created successfully")) {
            httpStatus = HttpStatus.CREATED;
        } else  if (result.equals("Seed Already Created")) {
            httpStatus = HttpStatus.CONFLICT;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }

    // Read all users in DB
    @GetMapping
    public ResponseEntity<List<Seed>> getAllSeedDetails() {
        List<Seed> seed = seedService.getAllSeed();
        return ResponseEntity.ok().body(seed);
    }

    @GetMapping("{seedId}")
    public ResponseEntity<Seed> getSeedDetails(@PathVariable("seedId") int seedId) {
        Seed seed = seedService.getSeed(seedId);
        if (seed != null) {
            return ResponseEntity.ok().body(seed);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{seedId}")
    public ResponseEntity<CreateResponse> updateSeedDetails(@PathVariable("seedId") int seedId, @RequestBody Seed seed) {
        String result = seedService.updateSeed(seedId, seed);
        HttpStatus httpStatus;
        if (result.equals("Seed updated successfully")) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }

    @DeleteMapping("{seedId}")
    public ResponseEntity<CreateResponse> deleteSeedDetails(@PathVariable("seedId") int seedId) {
        String result = seedService.deleteSeed(seedId);
        HttpStatus httpStatus;
        if (result.equals("Seed deleted successfully")) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }
}
