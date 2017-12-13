package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;

/**
 * Created by mkemp on 12/13/17.
 */

public class Player extends Entity {

    private static final int SPEED = 80;
    private static final int JUMP_VELOCITY = 5;

    Texture image;

    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("player.png");
    }

    @Override
    public void update(float dt, float gravity) {

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && grounded) {
            this.velocityY += JUMP_VELOCITY * getWeight();
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !grounded && this.velocityY > 0) {
            this.velocityY += JUMP_VELOCITY * getWeight() * dt;
        }

        super.update(dt, gravity); // Apply gravity

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveX(-SPEED * dt);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveX(SPEED * dt);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
    }
}
