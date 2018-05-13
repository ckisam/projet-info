package fr.sam.core.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * 'Sprite' du jeu, i.e �l�ment susceptible d'�tre dessin�, gr�ce � une image.
 * 
 * @author Samuel
 *
 */
public abstract class ZebraSprite extends Sprite implements IRenderable {

	public ZebraSprite() {
		super();
	}

	public ZebraSprite(Texture texture) {
		super(texture);
	}

}
