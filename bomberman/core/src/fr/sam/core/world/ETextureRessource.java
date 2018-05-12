package fr.sam.core.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum ETextureRessource {

	BOMBE("texture/bombe.png"), //
	EXPLOSION_FOYER("texture/explosionFoyer.png"), //
	EXPLOSION("texture/explosion.png");

	private final Texture texture;

	private ETextureRessource(String path) {
		this.texture = new Texture(Gdx.files.internal(path));
	}

	public Texture getTexture() {
		return texture;
	}

}
