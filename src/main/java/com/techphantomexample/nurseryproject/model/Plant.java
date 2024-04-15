package com.techphantomexample.nurseryproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plants_info")
public class Plant
{
    @Id
    @GeneratedValue
    private int plantId;
    private String plantName;
    private String plantDesc;
    private String plantCategory;
    private float plantPrice;
    private int plantQuantity;
    private boolean plantAvailability;

    public Plant() {
    }

    public Plant(String plantName, String plantDesc, String plantCategory, float plantPrice, int plantQuantity, boolean plantAvailability) {
        this.plantName = plantName;
        this.plantDesc = plantDesc;
        this.plantCategory = plantCategory;
        this.plantPrice = plantPrice;
        this.plantQuantity = plantQuantity;
        this.plantAvailability = plantAvailability;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantDesc() {
        return plantDesc;
    }

    public void setPlantDesc(String plantDesc) {
        this.plantDesc = plantDesc;
    }

    public String getPlantCategory() {
        return plantCategory;
    }

    public void setPlantCategory(String plantCategory) {
        this.plantCategory = plantCategory;
    }

    public float getPlantPrice() {
        return plantPrice;
    }

    public void setPlantPrice(float plantPrice) {
        this.plantPrice = plantPrice;
    }

    public int getPlantQuantity() {
        return plantQuantity;
    }

    public void setPlantQuantity(int plantQuantity) {
        this.plantQuantity = plantQuantity;
    }

    public boolean isPlantAvailability() {
        return plantAvailability;
    }

    public void setPlantAvailability(boolean plantAvailability) {
        this.plantAvailability = plantAvailability;
    }
}




