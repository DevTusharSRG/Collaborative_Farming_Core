package com.colabfarm.model;

import java.util.Date;

public class GovernmentSchemeModel {
    private int schemeId;
    private String title;
    private double price;
    private Date startDate;
    private Date lastDate;
    private String description;
    private Date createdDate;

    public GovernmentSchemeModel() {
    }

    public GovernmentSchemeModel(int schemeId, String title, double price, Date startDate, Date lastDate,
            String description, Date createdDate) {
        this.schemeId = schemeId;
        this.title = title;
        this.price = price;
        this.startDate = startDate;
        this.lastDate = lastDate;
        this.description = description;
        this.createdDate = createdDate;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
