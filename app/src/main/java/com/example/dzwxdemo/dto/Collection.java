package com.example.dzwxdemo.dto;

public class Collection {

    private Long id;
    private String name;
    private int imgUrl;

    public Collection(Long id, String name, int imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }
}
