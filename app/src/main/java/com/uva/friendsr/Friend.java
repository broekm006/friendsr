package com.uva.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;


    public Friend(String bio, String name, int drawableId) {
        this.bio = bio;
        this.name = name;
        this.drawableId = drawableId;

    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

