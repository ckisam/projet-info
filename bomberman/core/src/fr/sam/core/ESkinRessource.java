package fr.sam.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Repertorie les ressources pour les 'widgets'
 * 
 * @author Samuel
 *
 */
public enum ESkinRessource {

	COMIC("skin/comic-ui.json");

	private final Skin skin;

	private ESkinRessource(String path) {
		this.skin = new Skin(Gdx.files.internal("path"));
	}

	// Getters et setters

	public Skin getSkin() {
		return skin;
	}

}
