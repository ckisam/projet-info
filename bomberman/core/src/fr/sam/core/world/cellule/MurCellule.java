package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;

public class MurCellule extends ZebraCellule {

	public MurCellule(Texture texture) {
		super(texture);
	}

	@Override
	public boolean accessible() {
		return false;
	}

	@Override
	public boolean bloqueExplosion() {
		return true;
	}

	@Override
	public boolean accepteExplosion() {
		return false;
	}

}
