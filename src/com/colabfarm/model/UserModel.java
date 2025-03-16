package com.colabfarm.model;

import java.util.Date;

public class UserModel {
    private int id;
    private String nameOrCompanyName;
    private String contact;
    private String email;
    private String address;
    private String password;
    private String typeOfUser; // Enum: 'admin', 'farmer', 'company', 'service_provider'
    private Date createDate;

    public UserModel() {
    }

    public UserModel(int id, String nameOrCompanyName, String contact, String email, String address, String password,
            String typeOfUser, Date createDate) {
        this.id = id;
        this.nameOrCompanyName = nameOrCompanyName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.password = password;
        this.typeOfUser = typeOfUser;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOrCompanyName() {
        return nameOrCompanyName;
    }

    public void setNameOrCompanyName(String nameOrCompanyName) {
        this.nameOrCompanyName = nameOrCompanyName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
