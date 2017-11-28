package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;

import static com.mygdx.game.world.TileType.TILE_SIZE;

/**
 * Created by mkemp on 11/28/17.
 */

public abstract class GameMap {

    public abstract void render(OrthographicCamera camera);
    public abstract void update(float delta);
    public abstract void dispose();

    /**
     * Gets a time by pixel position within the game world at a specified layer.
     * @param layer
     * @param x
     * @param y
     * @return
     */
    public TileType getTileTypeByLocation(int layer, float x, float y) {
        return this.getTileTypeByCoordinate(layer, (int) (x / TILE_SIZE), (int) (y / TILE_SIZE));
    }

    /**
     * Gets a tile at its coordinate within the map at a specified layer.
     * @param layer
     * @param col
     * @param row
     * @return
     */
    public abstract TileType getTileTypeByCoordinate(int layer, float col, float row);

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();
}
