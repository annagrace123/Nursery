package com.techphantomexample.nurseryproject.model;

public class Seed
{
    private int seedId;
    private String seedName;
    private String seedDesc;
    private String seedCategory;
    private float seedPrice;
    private String seedPlantingSeason;
    private String seedGerminationTime;
    private int seedPackQuantity;
    private boolean plantAvailability;

    public Seed() {
    }

    public Seed(String seedName, String seedDesc, String seedCategory, float seedPrice, String seedPlantingSeason, String seedGerminationTime, int seedPackQuantity, boolean plantAvailability) {
        this.seedName = seedName;
        this.seedDesc = seedDesc;
        this.seedCategory = seedCategory;
        this.seedPrice = seedPrice;
        this.seedPlantingSeason = seedPlantingSeason;
        this.seedGerminationTime = seedGerminationTime;
        this.seedPackQuantity = seedPackQuantity;
        this.plantAvailability = plantAvailability;
    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    public String getSeedDesc() {
        return seedDesc;
    }

    public void setSeedDesc(String seedDesc) {
        this.seedDesc = seedDesc;
    }

    public String getSeedCategory() {
        return seedCategory;
    }

    public void setSeedCategory(String seedCategory) {
        this.seedCategory = seedCategory;
    }

    public float getSeedPrice() {
        return seedPrice;
    }

    public void setSeedPrice(float seedPrice) {
        this.seedPrice = seedPrice;
    }

    public String getSeedPlantingSeason() {
        return seedPlantingSeason;
    }

    public void setSeedPlantingSeason(String seedPlantingSeason) {
        this.seedPlantingSeason = seedPlantingSeason;
    }

    public String getSeedGerminationTime() {
        return seedGerminationTime;
    }

    public void setSeedGerminationTime(String seedGerminationTime) {
        this.seedGerminationTime = seedGerminationTime;
    }

    public int getSeedPackQuantity() {
        return seedPackQuantity;
    }

    public void setSeedPackQuantity(int seedPackQuantity) {
        this.seedPackQuantity = seedPackQuantity;
    }

    public boolean isPlantAvailability() {
        return plantAvailability;
    }

    public void setPlantAvailability(boolean plantAvailability) {
        this.plantAvailability = plantAvailability;
    }
}
