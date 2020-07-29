package com.example.dsproject;

public class ToyItem {
    private int toyID;
    private String toyName;
    private String toyDescription;
    private int dateOfManufacture;
    private int batchNumber;


    public ToyItem(int toyID, String toyName, String toyDescription, int dateOfManufacture, int batchNumber) {
        this.toyID = toyID;
        this.toyName = toyName;
        this.toyDescription = toyDescription;
        this.dateOfManufacture = dateOfManufacture;
        this.batchNumber = batchNumber;

    }

    public int getToyID() {
        return toyID;
    }

    public void setToyID(int toyID) {
        this.toyID = toyID;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public String getToyDescription() {
        return toyDescription;
    }

    public void setToyDescription(String toyDescription) {
        this.toyDescription = toyDescription;
    }

    public int getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(int dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

}
