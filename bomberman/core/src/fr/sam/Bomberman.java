package fr.sam;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bomberman extends Game implements ApplicationListener {

	public SpriteBatch batch;
	public AssetManager assets;

	@Override
	public void create() {
		batch = new SpriteBatch();
		assets = new AssetManager();

		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

}
