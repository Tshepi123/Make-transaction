package com.bean;

import java.sql.Timestamp;

public class paymentBean {
    private int id; //paymentID
    private String accNo;
    private String receiverAccNo;
    private String amount;
    private Timestamp paymentDate;
    
    private userBean user;
    
    public paymentBean(int id, String accNo, String receiverAccNo, String amount,Timestamp paymentDate, userBean user) {
        super();
        this.id = id;
        this.accNo = accNo;
        this.receiverAccNo = receiverAccNo;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.user = user;
    }
    
    public paymentBean() {
        super();
    }
    
    // Getters and Setters (shortcut select above and press ctrl + shift + alt + e)

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the accNo
     */
    public String getAccNo() {
        return accNo;
    }

    /**
     * @param accNo the accNo to set
     */
    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    /**
     * @return the receiverAccNo
     */
    public String getReceiverAccNo() {
        return receiverAccNo;
    }

    /**
     * @param receiverAccNo the receiverAccNo to set
     */
    public void setReceiverAccNo(String receiverAccNo) {
        this.receiverAccNo = receiverAccNo;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the paymentDate
     */
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the user
     */
    public userBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(userBean user) {
        this.user = user;
    }

}
