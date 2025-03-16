package com.colabfarm.model;

import java.util.Date;

public class AgreementModel {
    private int agreementId;
    private int userId;
    private int serviceId;
    private int propertyId;
    private String status; 
    private Date startDate;
    private Date endDate;
    private int timeDuration;
    private Date createDate;

    public AgreementModel() {
    }

    public AgreementModel(int agreementId, int userId, int serviceId, int propertyId, String status, Date startDate,
            Date endDate, int timeDuration, Date createDate) {
        this.agreementId = agreementId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.propertyId = propertyId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeDuration = timeDuration;
        this.createDate = createDate;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(int timeDuration) {
        this.timeDuration = timeDuration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
