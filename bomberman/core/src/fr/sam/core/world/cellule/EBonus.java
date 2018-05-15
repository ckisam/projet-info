package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;

import fr.sam.core.ETextureRessource;

public enum EBonus {

	VIE(ETextureRessource.VIE), FORCE(ETextureRessource.FORCE), RIEN(null);

	private final ETextureRessource textureRessource;

	private EBonus(ETextureRessource textureRessource) {
		this.textureRessource = textureRessource;
	}

	public Texture getTexture() {
		return textureRessource.getTexture();
	}

	// Getters et setters

	public ETextureRessource getTextureRessource() {
		return textureRessource;
	}

}
