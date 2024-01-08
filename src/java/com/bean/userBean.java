package com.bean;

public class userBean {

    private int id; //userID
    private String name;
    private String surname;
    private String email;
    private String idNum;
    private String phoneNo;
    private String loginUsername;
    private String loginPassword;

    public userBean() {
    }
    
    public userBean(int id, String name, String surname, String email, String idNum, String phoneNo, String loginUsername, String loginPassword) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.idNum = idNum;
        this.phoneNo = phoneNo;
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
    }
    
    // Getters and Setters [ctrl + shift + alt + e]

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

}