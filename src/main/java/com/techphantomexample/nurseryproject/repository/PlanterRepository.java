package com.techphantomexample.nurseryproject.repository;

import com.techphantomexample.nurseryproject.model.Planter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanterRepository extends JpaRepository<Planter,Integer> {

    boolean existsByPlanterName(String planterName);
}
