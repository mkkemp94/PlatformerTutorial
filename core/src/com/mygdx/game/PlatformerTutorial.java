package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.cutomgamemap.CustomGameMap;
import com.mygdx.game.world.GameMap;

public class PlatformerTutorial extends ApplicationAdapter {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private GameMap gameMap;

	@Override
	public void create () {
		batch = new SpriteBatch();

		// Set up camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();

		// This should really go in a game screen.
		gameMap = new CustomGameMap();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(camera, batch);

		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
	}
}
