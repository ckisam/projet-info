package fr.sam.core.world;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class ZebraWorld {

	private TiledMap tiledMap;
	private World world;
	private ZebraPlateau plateau;

	public ZebraWorld(TiledMap tiledMap) {
		super();
		this.tiledMap = tiledMap;
		this.world = new World(new Vector2(0, 0), true);
		// World.setVelocityThreshold(0.0f);
		this.plateau = new ZebraPlateau(tiledMap);
	}

	public void renderWorld(Batch batch) {
		plateau.renderPlateau(batch);
	}

	// Getters et setters

	public TiledMap getTiledMap() {
		return tiledMap;
	}

	public void setTiledMap(TiledMap tiledMap) {
		this.tiledMap = tiledMap;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public ZebraPlateau getPlateau() {
		return plateau;
	}

	public void setPlateau(ZebraPlateau plateau) {
		this.plateau = plateau;
	}

}
