package com.mygdx.game.entities;

/**
 * Created by mkemp on 12/1/17.
 */

public enum EntityType {

    // Other entities could be enemies.
    PLAYER("player", 14, 32, 40);

    private String id;
    private int width, height;
    private float weight;

    EntityType(String id, int width, int height, float weight) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }
}
