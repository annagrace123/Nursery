package com.techphantomexample.nurseryproject.services;

import com.techphantomexample.nurseryproject.model.Planter;

import java.util.List;

public interface PlanterService
{
    public String createPlanter(Planter planter);
    public String updatePlanter(int planterId ,Planter planter);
    public String deletePlanter(int planterId);
    public Planter getPlanter(int planterId);
    public List<Planter> getAllPlanter();
}
