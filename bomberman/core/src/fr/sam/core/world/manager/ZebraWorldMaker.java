package fr.sam.core.world.manager;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

import fr.sam.core.screen.EZebraLayerType;
import fr.sam.core.world.ZebraSprite;
import fr.sam.core.world.ZebraWorld;
import fr.sam.core.world.cellule.ZebraCellule;
import fr.sam.core.world.cellule.ZebraMechant;
import fr.sam.core.world.personnage.ZebraHero;

/**
 * Gestionnaire, dédié à la création d'un univers de jeu, à partir d'une carte
 * carroyée (Tiled Map)
 * 
 * @author Samuel
 *
 */
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

	/**
	 * Crée un univers de jeu à partir d'une carte carroyée (Tiled Map)
	 * 
	 * @param tiledMap
	 *            Carte carroyée
	 * @return
	 */
	public ZebraWorld make(TiledMap tiledMap) {
		ZebraWorld zebraWorld = new ZebraWorld(tiledMap);

		// Ajout des différentes couches
		for (EZebraLayerType layerType : EZebraLayerType.values()) {
			makeLayer(tiledMap, zebraWorld, layerType);
		}

		return (zebraWorld);
	}

	/**
	 * Alimente l'univers à partir des différentes couches de la carte carroyée
	 * 
	 * @param tiledMap
	 *            Carte carroyée
	 * @param zebraWorld
	 *            Univers Zebra
	 * @param layerType
	 *            Type de la couche traitée
	 */
	private void makeLayer(TiledMap tiledMap, ZebraWorld zebraWorld, EZebraLayerType layerType) {
		MapLayer mapLayer = tiledMap.getLayers().get(layerType.getLayerName());
		if (mapLayer != null && mapLayer instanceof TiledMapTileLayer) {
			TiledMapTileLayer tileLayer = (TiledMapTileLayer) mapLayer;
			for (int i = 0; i < tileLayer.getWidth(); i++) {
				for (int j = 0; j < tileLayer.getHeight(); j++) {
					Cell cell = tileLayer.getCell(i, j);
					if (cell != null) {
						TiledMapTile tile = cell.getTile();
						if (tile.getProperties().containsKey(layerType.getTileName())) {
							ZebraSprite zebraSprite = layerType.instantiate(tile.getTextureRegion().getTexture());
							if (zebraSprite instanceof ZebraCellule) {
								ZebraCellule cellule = (ZebraCellule) zebraSprite;
								zebraWorld.getPlateau().ajouterCellule(cellule, i, j);
							}
							if (zebraSprite instanceof ZebraHero) {
								ZebraHero hero = (ZebraHero) zebraSprite;
								zebraWorld.getPlateau().ajouterHero(hero, i, j);
							}
							if (zebraSprite instanceof ZebraMechant) {
								ZebraMechant mechant = (ZebraMechant) zebraSprite;
								zebraWorld.getPlateau().ajouterMechant(mechant, i, j);
							}
						}
					}
				}
			}
			mapLayer.setVisible(false);
		}
	}

}
