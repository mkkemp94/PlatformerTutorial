package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.cutomgamemap.CustomGameMap;
import com.mygdx.game.world.GameMap;
import com.mygdx.game.world.TileType;

public class PlatformerTutorial extends ApplicationAdapter {

	private OrthographicCamera camera;

	SpriteBatch batch;
	Texture img;

	private GameMap gameMap;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		// Set up camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();

		gameMap = new CustomGameMap();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isTouched()) {
			camera.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
			camera.update();
		}

		if (Gdx.input.justTouched()) {
			Vector3 position = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
			TileType tileType = gameMap.getTileTypeByLocation(1, position.x, position.y);

			if (tileType != null) {
				System.out.println("You clicked on tile with id " +
								tileType.getId() + " " +
								tileType.getName() + " " +
								tileType.isCollidable() + " " +
								tileType.getDamage());
			}
		}

		gameMap.render(camera);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
