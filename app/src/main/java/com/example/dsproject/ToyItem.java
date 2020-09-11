package com.example.dsproject;

public class ToyItem {

    private int id;
    private String name;
    private String description;
    private int price;
    private String dateOfManufacture;
    private int batchNumber;
    private String companyName;
    private String streetAddress;
    private int zipCode;
    private String countryName;


    public ToyItem(int id, String name, String description, int price, String dateOfManufacture, int batchNumber, String companyName, String streetAddress, int zipCode, String countryName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.batchNumber = batchNumber;
        this.companyName = companyName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.countryName = countryName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}



