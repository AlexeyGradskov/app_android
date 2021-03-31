package com.example.school;

public class Service {
    private final int duration;
    private final int discount;
    private final int mainImagePath;
    private final String title;
    private final String description;
    private final double cost;

    public Service(int id, String title, double cost,
                   int duration, String description,
                   int discount, int mainImagePath) {
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

    public int getDuration() {
        return duration;
    }

    public int getDiscount() {
        return discount;
    }

    public double getCost() {
        return cost;
    }

    public int getMainImagePath() {
        return mainImagePath;
    }

    public String getTitle() {
        return title;
    }

}
