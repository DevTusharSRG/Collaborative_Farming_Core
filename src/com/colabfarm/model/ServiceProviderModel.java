package com.colabfarm.model;

import java.util.Date;

public class ServiceProviderModel {
    private int id;
    private int serviceId;
    private int serviceProviderId; 
    private double price;
    private int duration;
    private String unitType;
    private String description;
    private Date createDate;

    public ServiceProviderModel() {
    }

    public ServiceProviderModel(int id, int serviceId, int serviceProviderId, double price, int duration,
    String unitType, String description, Date createDate) {
this.id = id;
this.serviceId = serviceId;
this.serviceProviderId = serviceProviderId;
this.price = price;
this.duration = duration;
this.unitType = unitType;
this.description = description;
this.createDate = createDate;
}


@Override
public String toString() {
    return "User ID: " + id + 
           ", serviceId: " + serviceId + 
           ", serviceProviderId: " + serviceProviderId + 
           ", price: " + price + 
           ", duration: " + duration + 
           ", unitType: " + unitType + 
           ", description: " + description;
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(int serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
