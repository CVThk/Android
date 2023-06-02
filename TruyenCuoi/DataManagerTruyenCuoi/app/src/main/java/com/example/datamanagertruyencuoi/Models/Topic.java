package com.example.datamanagertruyencuoi.Models;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Topic extends RealmObject implements Serializable {
    @PrimaryKey
    private int id;
    @Required
    private String name;
    @Required
    private byte[] image;

    private RealmList<Story> stories;

    public Topic() {}

    public Topic(int id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public RealmList<Story> getStories() {
        return stories;
    }

    public void setStories(RealmList<Story> stories) {
        this.stories = stories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
