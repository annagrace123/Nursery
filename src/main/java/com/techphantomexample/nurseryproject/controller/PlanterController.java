package com.techphantomexample.nurseryproject.controller;

import com.techphantomexample.nurseryproject.model.Planter;
import com.techphantomexample.nurseryproject.model.Seed;
import com.techphantomexample.nurseryproject.services.PlanterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planter")
public class PlanterController
{
    PlanterService planterService;

    public PlanterController(PlanterService planterService) {
        this.planterService = planterService;
    }

    @PostMapping
    public ResponseEntity<CreateResponse> createPlanter(@RequestBody Planter planter) {
        String result = planterService.createPlanter(planter);
        HttpStatus httpStatus = null;
        if (result.equals("Planter Created successfully")) {
            httpStatus = HttpStatus.CREATED;
        } else  if (result.equals("Planter Already Created")) {
            httpStatus = HttpStatus.CONFLICT;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }

    // Read all users in DB
    @GetMapping
    public ResponseEntity<List<Planter>> getAllPlanterDetails() {
        List<Planter> planter = planterService.getAllPlanter();
        return ResponseEntity.ok().body(planter);
    }

    @GetMapping("{planterId}")
    public ResponseEntity<Planter> getPlanterDetails(@PathVariable("planterId") int planterId) {
        Planter planter = planterService.getPlanter(planterId);
        if (planter != null) {
            return ResponseEntity.ok().body(planter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{planterId}")
    public ResponseEntity<CreateResponse> updatePlanterDetails(@PathVariable("planterId") int planterId, @RequestBody Planter planter) {
        String result = planterService.updatePlanter(planterId, planter);
        HttpStatus httpStatus;
        if (result.equals("Planter updated successfully")) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }

    @DeleteMapping("{planterId}")
    public ResponseEntity<CreateResponse> deletePlanterDetails(@PathVariable("planterId") int planterId) {
        String result = planterService.deletePlanter(planterId);
        HttpStatus httpStatus;
        if (result.equals("Planter deleted successfully")) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }
}
