package fr.sam.core.screen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import fr.sam.core.ETextureRessource;

public class BoutonBombe extends ImageButton {

	private static final Drawable IMAGE_UP = new TextureRegionDrawable(
			new TextureRegion(ETextureRessource.BOUTON_BOMBE.getTexture()));
	private static final Drawable IMAGE_DOWN = new TextureRegionDrawable(
			new TextureRegion(ETextureRessource.BOUTON_BOMBE_DOWN.getTexture()));

	public BoutonBombe() {
		super(IMAGE_UP, IMAGE_DOWN);
	}

}
