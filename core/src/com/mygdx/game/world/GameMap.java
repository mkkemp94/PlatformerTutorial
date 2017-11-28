package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by mkemp on 11/28/17.
 */

public abstract class GameMap {

    public abstract void render(OrthographicCamera camera);
    public abstract void update(float delta);
    public abstract void dispose();
}
