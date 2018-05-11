package fr.sam.core.world.manager;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import fr.sam.core.world.EZebraSpriteType;
import fr.sam.core.world.TileInfo;
import fr.sam.core.world.ZebraSprite;
import fr.sam.core.world.ZebraWorld;

public class ZebraWorldMaker {

	private static volatile ZebraWorldMaker maker;

	private ZebraWorldMaker() {
		super();
	}

	public static ZebraWorldMaker getInstance() {
		if (maker == null) {
			synchronized (ZebraWorldMaker.class) {
				if (maker == null) {
					maker = new ZebraWorldMaker();
				}
			}
		}
		return (maker);
	}

	public ZebraWorld make(TiledMap tiledMap) {
		World world = new World(new Vector2(0, 0), true);
		// World.setVelocityThreshold(0.0f);
		ZebraWorld res = new ZebraWorld(tiledMap, world);

		// Ajout des murs
		makeLayer(tiledMap, res, EZebraSpriteType.MUR);

		// Ajout des briques
		makeLayer(tiledMap, res, EZebraSpriteType.BRIQUE);

		// Ajout du zebre
		makeLayer(tiledMap, res, EZebraSpriteType.ZEBRA);

		return (res);
	}

	private void makeLayer(TiledMap tiledMap, ZebraWorld zebraWorld, EZebraSpriteType type) {
		MapLayer mapLayer = tiledMap.getLayers().get(type.getLayerName());
		if (mapLayer != null && mapLayer instanceof TiledMapTileLayer) {
			TiledMapTileLayer tileLayer = (TiledMapTileLayer) mapLayer;
			float tileWidth = tileLayer.getTileWidth();
			float tileHeight = tileLayer.getTileHeight();
			for (int i = 0; i < tileLayer.getWidth(); i++) {
				for (int j = 0; j < tileLayer.getHeight(); j++) {
					Cell cell = tileLayer.getCell(i, j);
					if (cell != null) {
						TiledMapTile tile = cell.getTile();
						if (tile.getProperties().containsKey(type.getTileName())) {
							TileInfo tileInfo = new TileInfo(i, j, tileWidth, tileHeight);
							ZebraSprite zebraSprite = ZebraSpriteFactory.getInstance().create(type, zebraWorld,
									tileInfo, tile.getTextureRegion());
							zebraWorld.ajouterZebraSprite(zebraSprite);
						}
					}
				}
			}
			mapLayer.setVisible(false);
		}
	}

}
