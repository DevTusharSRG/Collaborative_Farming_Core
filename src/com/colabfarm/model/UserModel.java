package com.colabfarm.model;

import java.util.Date;

public class UserModel {
    private int id;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String password;
    private String typeOfUser; 
    private Date createDate;

    public UserModel() {
    }

    public UserModel(int id, String name, String contact, String email, String address, String password,
            String typeOfUser, Date createDate) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.password = password;
        this.typeOfUser = typeOfUser;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User ID: " + id + 
               ", Name: " + name + 
               ", Contact: " + contact + 
               ", Email: " + email + 
               ", Address: " + address + 
               ", User Type: " + typeOfUser + 
               ", Created On: " + createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
