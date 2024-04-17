package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.Planter;
import com.techphantomexample.nurseryproject.model.Seed;
import com.techphantomexample.nurseryproject.repository.PlanterRepository;
import com.techphantomexample.nurseryproject.repository.SeedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanterServiceImp implements PlanterService{

    PlanterRepository planterRepository;

    public PlanterServiceImp(PlanterRepository planterRepository) {
        this.planterRepository = planterRepository;
    }

    @Override
    public String createPlanter(Planter planter) {
        String planterName = planter.getPlanterName();

        if (planterName != null && existsByPlanterName(planterName)) {
            return "Planter Already Created";
        }
        planterRepository.save(planter);
        return "Planter Created successfully";
    }

    private boolean existsByPlanterName(String planterName) {
        return planterRepository.existsByPlanterName(planterName);
    }

    @Override
    public String updatePlanter(int planterId, Planter newPlanterDetails) {
        Optional<Planter> optionalUser = planterRepository.findById(planterId);
        if (optionalUser.isPresent()) {
            Planter existingPlanter = optionalUser.get();

            existingPlanter.setPlanterName(newPlanterDetails.getPlanterName());
            existingPlanter.setPlanterCategory(newPlanterDetails.getPlanterCategory());
            existingPlanter.setPlanterDesc(newPlanterDetails.getPlanterDesc());
            existingPlanter.setPlanterQuantity(newPlanterDetails.getPlanterQuantity());
            existingPlanter.setPlanterPrice(newPlanterDetails.getPlanterPrice());
            existingPlanter.setPlanterColour(newPlanterDetails.getPlanterColour());
            existingPlanter.setPlanterSize(newPlanterDetails.getPlanterSize());
            existingPlanter.setPlanterAvailability(newPlanterDetails.isPlanterAvailability());


            planterRepository.save(existingPlanter);

            return "Planter updated successfully";
        } else {

            return "";
        }
    }

    @Override
    public String deletePlanter(int planterId) {
        if (planterRepository.existsById(planterId))
        {
            planterRepository.deleteById(planterId);
            return "Planter deleted successfully";
        }
        return "Planter not found";
    }

    @Override
    public Planter getPlanter(int planterId) {
        return planterRepository.findById(planterId).get();
    }

    @Override
    public List<Planter> getAllPlanter() {
        return planterRepository.findAll();
    }
}
