package com.colabfarm.model;

import java.util.Date;

public class PropertyModel {
    private int propertyId;
    private int farmerId;
    private String location;
    private String typeOfLand;
    private String landImage;
    private String documentImage;
    private double areaAcre;
    private double areaGuntha;
    private Date createDate;

    public PropertyModel() {
    }

    public PropertyModel(int propertyId, int farmerId, String location, String typeOfLand, String landImage,
            String documentImage, double areaAcre, double areaGuntha, Date createDate) {
        this.propertyId = propertyId;
        this.farmerId = farmerId;
        this.location = location;
        this.typeOfLand = typeOfLand;
        this.landImage = landImage;
        this.documentImage = documentImage;
        this.areaAcre = areaAcre;
        this.areaGuntha = areaGuntha;
        this.createDate = createDate;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTypeOfLand() {
        return typeOfLand;
    }

    public void setTypeOfLand(String typeOfLand) {
        this.typeOfLand = typeOfLand;
    }

    public String getLandImage() {
        return landImage;
    }

    public void setLandImage(String landImage) {
        this.landImage = landImage;
    }

    public String getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(String documentImage) {
        this.documentImage = documentImage;
    }

    public double getAreaAcre() {
        return areaAcre;
    }

    public void setAreaAcre(double areaAcre) {
        this.areaAcre = areaAcre;
    }

    public double getAreaGuntha() {
        return areaGuntha;
    }

    public void setAreaGuntha(double areaGuntha) {
        this.areaGuntha = areaGuntha;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
