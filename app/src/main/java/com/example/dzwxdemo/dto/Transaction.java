package com.example.dzwxdemo.dto;

public class Transaction {
    private String status;
    private String name;
    private Long id;
    private String createTime;
    private String price;
    private int imageUrl;

    public Transaction(String name, Long id, String createTime, String price, int imageUrl, String status) {
        this.name = name;
        this.createTime = createTime;
        this.id = id;
        this.price = price;
        this.imageUrl = imageUrl;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getName() {
        return name;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
