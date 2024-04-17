package com.techphantomexample.nurseryproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planters_info")
public class Planter
{
    @Id
    @GeneratedValue
    private int planterId;
    private String planterName;
    private String planterDesc;
    private String planterCategory;
    private float planterPrice;
    private char planterSize;
    private String planterColour;
    private int planterQuantity;
    private boolean planterAvailability;

    public Planter(String planterName, String planterDesc, String planterCategory, float planterPrice, char planterSize, String planterColour, int planterQuantity, boolean planterAvailability) {
        this.planterName = planterName;
        this.planterDesc = planterDesc;
        this.planterCategory = planterCategory;
        this.planterPrice = planterPrice;
        this.planterSize = planterSize;
        this.planterColour = planterColour;
        this.planterQuantity = planterQuantity;
        this.planterAvailability = planterAvailability;
    }

    public Planter() {
    }

    public String getPlanterName() {
        return planterName;
    }

    public void setPlanterName(String planterName) {
        this.planterName = planterName;
    }

    public String getPlanterDesc() {
        return planterDesc;
    }

    public void setPlanterDesc(String planterDesc) {
        this.planterDesc = planterDesc;
    }

    public String getPlanterCategory() {
        return planterCategory;
    }

    public void setPlanterCategory(String planterCategory) {
        this.planterCategory = planterCategory;
    }

    public float getPlanterPrice() {
        return planterPrice;
    }

    public void setPlanterPrice(float planterPrice) {
        this.planterPrice = planterPrice;
    }

    public char getPlanterSize() {
        return planterSize;
    }

    public void setPlanterSize(char planterSize) {
        this.planterSize = planterSize;
    }

    public String getPlanterColour() {
        return planterColour;
    }

    public void setPlanterColour(String planterColour) {
        this.planterColour = planterColour;
    }

    public int getPlanterQuantity() {
        return planterQuantity;
    }

    public void setPlanterQuantity(int planterQuantity) {
        this.planterQuantity = planterQuantity;
    }

    public boolean isPlanterAvailability() {
        return planterAvailability;
    }

    public void setPlanterAvailability(boolean planterAvailability) {
        this.planterAvailability = planterAvailability;
    }
}
