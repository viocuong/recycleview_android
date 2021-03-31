package com.example.recycleview.model;

public class Cat {
    private int rsImg;
    private String name;
    private double weight;

    public Cat(int rsImg, String name, double weight) {
        this.rsImg = rsImg;
        this.name = name;
        this.weight = weight;
    }

    public Cat() {
    }

    public int getRsImg() {
        return rsImg;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

}
