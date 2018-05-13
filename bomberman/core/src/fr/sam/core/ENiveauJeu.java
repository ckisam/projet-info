package fr.sam.core;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Les différents niveaux du jeu
 * 
 * @author Samuel
 *
 */
public enum ENiveauJeu {

	NIVEAU_1(1, "cartes/niveau1.tmx"), //
	NIVEAU_2(2, "cartes/niveau2.tmx");

	private final int rang;
	private final TiledMap tiledMap;

	private ENiveauJeu(int rang, String path) {
		this.rang = rang;
		this.tiledMap = new TmxMapLoader().load(path);
	}

	// Getters et setters

	public int getRang() {
		return rang;
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}

}
