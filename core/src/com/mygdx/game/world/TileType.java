package com.mygdx.game.world;

import java.util.HashMap;

/**
 * Created by mkemp on 11/28/17.
 */

public enum TileType {

    GRASS   (1, true, "Grass"),
    DIRT    (2, true, "Dirt"),
    SKY     (3, false, "Sky"),
    LAVA    (4, true, "Lava"),
    CLOUD   (5, true, "Cloud"),
    STONE   (6, true, "Stone");

    public static final int TILE_SIZE = 16;

    private int id;
    private boolean collidable;
    private String name;
    private float damage;

    private TileType(int id, boolean collidable, String name) {
        this(id, collidable, name, 0);
    }

    private TileType(int id, boolean collidable, String name, float damage) {
        this.id = id;
        this.collidable = collidable;
        this.name = name;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public void setCollidable(boolean collidable) {
        this.collidable = collidable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    // Get enum based on id
    private static HashMap<Integer, TileType> tileMap;

    static {
        tileMap = new HashMap<Integer, TileType>();
        for (TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById (int id) {
        return tileMap.get(id);
    }
}
