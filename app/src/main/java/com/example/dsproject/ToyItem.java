package com.example.dsproject;

public class ToyItem {

    private int id;
    private String name;
    private String description;
    private int price;
    private String dateOfManufacture;
    private int batchNumber;

    public ToyItem(Integer id, String name, String description, int price, String dateOfManufacture, Integer batchNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.batchNumber = batchNumber;
    }

    public ToyItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToyName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToyDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getToyPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }
}



