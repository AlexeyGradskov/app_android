package com.example.school;

public class Service {
    private final int id;
    private final int duration;
    private final float discount;
    private final byte[] photo;
    private final String title;
    private final int cost;

    public Service(int id, String title, int cost,
                   int duration,
                   float discount, byte[] photo) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.duration = duration;
        this.discount = discount;
        this.photo = photo;
    }

    public double getOldCost() {
        return cost + ((cost * discount) / 100);
    }

    public int getDuration() {
        return duration;
    }

    public float getDiscount() {
        return discount;
    }

    public int getCost() {
        return cost;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
