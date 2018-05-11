package fr.sam.core.world;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;

import fr.sam.core.ZebraConstantes;

public class ZebraWorld {

	private final World world;
	private final TiledMap tiledMap;
	private Zebra zebra;
	private ZebraSprite[][] worldElementTab;

	public ZebraWorld(TiledMap tiledMap, World world) {
		super();
		this.world = world;
		this.tiledMap = tiledMap;
		MapProperties prop = tiledMap.getProperties();
		this.worldElementTab = new ZebraSprite[prop.get(ZebraConstantes.MAP_WIDTH_KEY, Integer.class)][prop
				.get(ZebraConstantes.MAP_HEIGHT_KEY, Integer.class)];
	}

	public void renderWorld(Batch batch) {
		batch.begin();
		for (int i = 0; i < this.worldElementTab.length; i++) {
			for (int j = 0; j < this.worldElementTab[i].length; j++) {
				ZebraSprite zebraSprite = this.worldElementTab[i][j];
				if (zebraSprite != null) {
					zebraSprite.render(batch);
				}
			}
		}
		if (zebra != null) {
			zebra.render(batch);
		}
		batch.end();
	}

	public void ajouterZebraSprite(ZebraSprite zebraSprite) {
		if (zebraSprite != null) {
			if (zebraSprite instanceof Zebra) {
				this.zebra = (Zebra) zebraSprite;
			} else {
				this.worldElementTab[zebraSprite.getIndexX()][zebraSprite.getIndexY()] = zebraSprite;
			}
		}
	}

	// Getters et setters

	public World getWorld() {
		return world;
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}

	public Zebra getZebra() {
		return zebra;
	}

	public void setZebra(Zebra zebra) {
		this.zebra = zebra;
	}

	public ZebraSprite[][] getWorldElementTab() {
		return worldElementTab;
	}

}
