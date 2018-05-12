package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.g2d.Batch;

public class CelluleVide extends ZebraCellule {

	@Override
	public void render(Batch batch) {
		// La cellule est vide, on ne fait rien
		if (estMinee()) {
			getBombe().render(batch);
		}
		if (explose()) {
			getExplosion().render(batch);
		}
	}

	@Override
	public boolean accessible() {
		return true && !estMinee();
	}

	@Override
	public boolean bloqueExplosion() {
		return false;
	}

	@Override
	public boolean accepteExplosion() {
		return true;
	}

}
