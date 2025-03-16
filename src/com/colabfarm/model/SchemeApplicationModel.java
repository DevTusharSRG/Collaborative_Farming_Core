package com.colabfarm.model;

import java.util.Date;

public class SchemeApplicationModel {
    private int applicationId;
    private int schemeId;
    private int farmerId;
    private Date registerDate;
    private String status; 

    public SchemeApplicationModel() {
    }

    public SchemeApplicationModel(int applicationId, int schemeId, int farmerId, Date registerDate, String status) {
        this.applicationId = applicationId;
        this.schemeId = schemeId;
        this.farmerId = farmerId;
        this.registerDate = registerDate;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
