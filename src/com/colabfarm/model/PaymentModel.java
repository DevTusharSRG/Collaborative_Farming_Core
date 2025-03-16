package com.colabfarm.model;

import java.util.Date;

public class PaymentModel {
    private int paymentId;
    private int agreementId;
    private double totalAmount;
    private String paymentMethod; 
    private String paymentMode; 
    private String paymentStatus; 
    private String transactionId;
    private Date receivedDate;

    public PaymentModel() {
    }

    public PaymentModel(int paymentId, int agreementId, double totalAmount, String paymentMethod, String paymentMode,
            String paymentStatus, String transactionId, Date receivedDate) {
        this.paymentId = paymentId;
        this.agreementId = agreementId;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.receivedDate = receivedDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
}
