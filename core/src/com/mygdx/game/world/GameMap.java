package com.mygdx.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Player;

import java.util.ArrayList;

import static com.mygdx.game.world.TileType.TILE_SIZE;

/**
 * Created by mkemp on 11/28/17.
 */

public abstract class GameMap {

    protected ArrayList<Entity> entities;

    public GameMap() {
        entities = new ArrayList<Entity>();
        entities.add(new Player(40, 450, this));
    }

    public void render(OrthographicCamera camera, SpriteBatch batch) {
        for (Entity entity : entities) {
            entity.render(batch);
        }
    }

    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta, -9.8f);
        }
    }

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
    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);

    // Collision deterction
    public boolean doesRectCollideWithMap(float x, float y, int width, int height) {

        // Outside of map
        if (x < 0 || y < 0 || x + width > getPixelHeight() || y + height > getPixelHeight())
            return true;

        // Ay other collision
        for (int row = (int) y / TileType.TILE_SIZE; row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
            for (int col = (int) x / TileType.TILE_SIZE; col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {
                    TileType type = getTileTypeByCoordinate(layer, col, row);
                    if (type != null && type.isCollidable()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();

    public int getPixelWidth() {
        return this.getWidth() * TileType.TILE_SIZE;
    }

    public int getPixelHeight() {
        return this.getHeight() * TileType.TILE_SIZE;
    }
}
