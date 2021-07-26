package com.example.dzwxdemo.dto;

public class Exam {
    private Long id;
    private int imgUrl;
    private String name;
    private String grade;
    private String time;

    public Exam(Long id, int imgUrl, String name, String grade, String time) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.grade = grade;
        this.time = time;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getTime() {
        return time;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
