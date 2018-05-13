package fr.sam.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.sam.core.screen.EcranMenu;

/**
 * Classe centrale, appelée par le lanceur adapté (bureau, android, ...)
 * 
 * @author Samuel
 *
 */
public class BombaZebra extends Game implements ApplicationListener {

	private SpriteBatch batch;
	private AssetManager assets;

	@Override
	public void create() {
		batch = new SpriteBatch();
		assets = new AssetManager();

		this.setScreen(new EcranMenu(this));
	}

	@Override
	public void render() {
		super.render();
	}

	// Getters et setters

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public AssetManager getAssets() {
		return assets;
	}

	public void setAssets(AssetManager assets) {
		this.assets = assets;
	}

}
