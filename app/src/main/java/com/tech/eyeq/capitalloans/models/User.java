package com.tech.eyeq.capitalloans.models;

public class User {

    private String name, phone, id_no, token, dob;
    private Boolean verified;

    public User(String name, String phone, String id_no, String token, String dob, Boolean verified) {
        this.name = name;
        this.phone = phone;
        this.id_no = id_no;
        this.token = token;
        this.dob = dob;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
