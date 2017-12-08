package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.world.GameMap;

/**
 * Created by mkemp on 12/8/17.
 */

public abstract class Entity {

    protected Vector2 pos;
    protected EntityType type;
    protected float velocityY = 0;
    protected GameMap map;
    protected boolean grounded = false;


    public Entity(float x, float y, EntityType type, GameMap map, boolean grounded) {
        this.pos = new Vector2(x, y);
        this.type = type;
        this.map = map;
        this.grounded = grounded;
    }

    public void update(float dt, float gravity) {

    }

    public abstract void render(SpriteBatch batch);

    protected void moveX(float amount) {

    }

    public Vector2 getPos() {
        return pos;
    }

    public float getX() {
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }

    public EntityType getType() {
        return type;
    }

    public boolean isGrounded() {
        return grounded;
    }

    public int getWidth() {
        return type.getWidth();
    }

    public int getHeight() {
        return type.getHeight();
    }

    public float getWeight() {
        return type.getWeight();
    }
}
