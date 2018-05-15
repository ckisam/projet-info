package fr.sam.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Repertorie les ressources de texture, i.e les images du jeu.
 * 
 * @author Samuel
 *
 */
public enum ETextureRessource {

	BOMBE("texture/bombe.png"), //
	EXPLOSION_FOYER("texture/explosionFoyer.png"), //
	EXPLOSION("texture/explosion.png"), //
	BOUTON_BOMBE("texture/boutonBombe.png"), //
	BOUTON_BOMBE_DOWN("texture/boutonBombeDown.png"), //
	ZEBRE_ACCUEIL("texture/zebreAccueil.png"), //
	VIE("texture/vie.png"), //
	FORCE("texture/bonus.png"), //
	SORTIE("texture/sortie.png");

	private final Texture texture;

	private ETextureRessource(String path) {
		this.texture = new Texture(Gdx.files.internal(path));
	}

	public Texture getTexture() {
		return texture;
	}

}
