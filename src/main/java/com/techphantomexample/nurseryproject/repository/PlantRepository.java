package com.techphantomexample.nurseryproject.repository;

import com.techphantomexample.nurseryproject.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository <Plant, Integer>
{
      boolean existsByPlantName(String plantName);
}
