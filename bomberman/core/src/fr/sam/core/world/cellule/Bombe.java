package fr.sam.core.world.cellule;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.g2d.Batch;

import fr.sam.core.ETextureRessource;
import fr.sam.core.ZebraConstantes;
import fr.sam.core.world.ZebraSprite;

public class Bombe extends ZebraSprite {

	// private static final int COMPTE_A_REBOURS = 4000;
	private static final int COMPTE_A_REBOURS = 2000;

	private ZebraCellule cellule;
	private int force = ZebraConstantes.BOMB_DEFAULT_FORCE;

	private boolean enclenchee;
	private long nanoTime;

	public Bombe(ZebraCellule cellule) {
		super(ETextureRessource.BOMBE.getTexture());
		this.cellule = cellule;
		setPosition(cellule.getX(), cellule.getY());
	}

	@Override
	public void render(Batch batch) {
		gererExplosion();
		if (enclenchee) {
			this.draw(batch);
		}
	}

	public void enclencher() {
		this.enclenchee = true;
		this.nanoTime = System.nanoTime();
	}

	private void gererExplosion() {
		long timeDiff = System.nanoTime() - nanoTime;
		if (TimeUnit.MILLISECONDS.convert(timeDiff, TimeUnit.NANOSECONDS) > COMPTE_A_REBOURS) {
			exploser();
		}
	}

	public void exploser() {
		this.enclenchee = false;
		this.cellule.enleverBombe();
		Explosion foyer = new FoyerExplosion(this.cellule);
		foyer.setForce(force);
		this.cellule.gererNouvelleExplosion(foyer);
		// TODO toute la gestion des cellules concernée
	}

}
