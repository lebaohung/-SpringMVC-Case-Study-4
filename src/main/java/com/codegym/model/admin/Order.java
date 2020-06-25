package com.codegym.model.admin;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;
    private int status;
    private float weight;
    private Date createdDate;
    private String note;
    private String active;
    private String notActive;
    private String pending;
    public Order(){}
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statuses;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getNotActive() {
        return notActive;
    }

    public void setNotActive(String notActive) {
        this.notActive = notActive;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Status getStatuses() {
        return statuses;
    }

    public void setStatuses(Status statuses) {
        this.statuses = statuses;
    }

    public Order(Long orderId, String receiverName, String receiverAddress, String receiverPhone, int status, float weight, Date createdDate, String note, String active, String notActive, String pending, User user, Province province, Status statuses) {
        this.orderId = orderId;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverPhone = receiverPhone;
        this.status = status;
        this.weight = weight;
        this.createdDate = createdDate;
        this.note = note;
        this.active = active;
        this.notActive = notActive;
        this.pending = pending;
        this.user = user;
        this.province = province;
        this.statuses = statuses;
    }


}
