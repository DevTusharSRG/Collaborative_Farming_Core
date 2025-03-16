package com.colabfarm.model;

import java.util.Date;

public class ServiceProviderModel {
    private int id;
    private int serviceId;
    private int userId;
    private double price;
    private int duration;
    private String description;
    private Date createDate;

    public ServiceProviderModel() {}

    public ServiceProviderModel(int id, int serviceId, int userId, double price, int duration, String description, Date createDate) {
        this.id = id;
        this.serviceId = serviceId;
        this.userId = userId;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.createDate = createDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getServiceId() { return serviceId; }
    public void setServiceId(int serviceId) { this.serviceId = serviceId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
}
