package com.example.school;

public class Service {
    private int id, duration, discount, mainImagePath;
    private String title, description;
    private double cost;

    public Service(int id, String title, double cost,
                   int duration, String description,
                   int discount, int mainImagePath) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.duration = duration;
        this.description = description;
        this.discount = discount;
        this.mainImagePath = mainImagePath;
    }

    public double getOldCost() {
        return cost + ((cost * discount) / 100);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMainImagePath() {
        return mainImagePath;
    }

    public void setMainImagePath(int mainImagePath) {
        this.mainImagePath = mainImagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
