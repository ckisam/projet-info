package fr.sam.core.screen;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;

/**
 * POJO résumant les informations d'une carte carroyée (nombre de carreaux et
 * taille).
 * 
 * @author Samuel
 *
 */
public class TiledMapInfo {

	private static final String NB_TILE_WIDTH = "width";
	private static final String NB_TILE_HEIGHT = "height";
	private static final String TILE_WIDTH = "tilewidth";
	private static final String TILE_HEIGHT = "tileheight";

	private int nbTileWidth;
	private int nbTileHeight;
	private int tileWidth;
	private int tileHeight;

	public TiledMapInfo(TiledMap tiledMap) {
		super();
		MapProperties prop = tiledMap.getProperties();
		this.nbTileWidth = prop.get(NB_TILE_WIDTH, Integer.class);
		this.nbTileHeight = prop.get(NB_TILE_HEIGHT, Integer.class);
		this.tileWidth = prop.get(TILE_WIDTH, Integer.class);
		this.tileHeight = prop.get(TILE_HEIGHT, Integer.class);
	}

	/**
	 * @return Largeur de la carte.
	 */
	public int getWidth() {
		return nbTileWidth * tileWidth;
	}

	/**
	 * @return Hauteur de la carte.
	 */
	public int getHeight() {
		return nbTileHeight * tileHeight;
	}

	// Getters et setters

	public int getNbTileWidth() {
		return nbTileWidth;
	}

	public void setNbTileWidth(int nbTileWidth) {
		this.nbTileWidth = nbTileWidth;
	}

	public int getNbTileHeight() {
		return nbTileHeight;
	}

	public void setNbTileHeight(int nbTileHeight) {
		this.nbTileHeight = nbTileHeight;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

}
