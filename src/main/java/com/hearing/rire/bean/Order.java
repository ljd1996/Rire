package com.hearing.rire.bean;

public class Order {
    private Integer id;

    private String location;

    private Integer status;

    private Integer userSupplierId;

    private Integer userBuyerId;

    private Integer proSupplierId;

    private Long orderTime;

    private Long finishTime;

    private Long payTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserSupplierId() {
        return userSupplierId;
    }

    public void setUserSupplierId(Integer userSupplierId) {
        this.userSupplierId = userSupplierId;
    }

    public Integer getUserBuyerId() {
        return userBuyerId;
    }

    public void setUserBuyerId(Integer userBuyerId) {
        this.userBuyerId = userBuyerId;
    }

    public Integer getProSupplierId() {
        return proSupplierId;
    }

    public void setProSupplierId(Integer proSupplierId) {
        this.proSupplierId = proSupplierId;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }
}