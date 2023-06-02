package com.example.hocke_customlistview;

public class Fruit {
    String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return getName() + ".png";
    }
}
