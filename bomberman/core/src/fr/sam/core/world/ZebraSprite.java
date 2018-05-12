package fr.sam.core.world;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class ZebraSprite extends Sprite implements IRenderable {

	public ZebraSprite() {
		super();
	}

	public ZebraSprite(Texture texture) {
		super(texture);
	}

}
