package com.hearing.rire.bean;

public class Order {
    private Integer id;

    private Long time;

    private Integer status;

    private Integer userSupplierId;

    private Integer userBuyerId;

    private Integer proSupplierId;

    private Integer proBuyerId;

    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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

    public Integer getProBuyerId() {
        return proBuyerId;
    }

    public void setProBuyerId(Integer proBuyerId) {
        this.proBuyerId = proBuyerId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}