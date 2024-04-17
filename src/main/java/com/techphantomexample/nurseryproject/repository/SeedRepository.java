package com.techphantomexample.nurseryproject.repository;

import com.techphantomexample.nurseryproject.model.Plant;
import com.techphantomexample.nurseryproject.model.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedRepository extends JpaRepository<Seed, Integer>
{
    boolean existsBySeedName(String seedName);
}
