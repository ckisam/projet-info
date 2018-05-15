package fr.sam.core.world.cellule;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.g2d.Batch;

import fr.sam.core.ETextureRessource;
import fr.sam.core.world.ZebraSprite;
import fr.sam.core.world.personnage.ZebraPersonnage;

/**
 * Bombe déposée par un personnage.
 * 
 * @author Samuel
 *
 */
public class Bombe extends ZebraSprite {

	private static final int COMPTE_A_REBOURS = 5000;

	private ZebraCellule cellule;
	private int force;

	private boolean enclenchee;
	private long nanoTime;

	public Bombe(ZebraPersonnage personnage) {
		super(ETextureRessource.BOMBE.getTexture());
		this.cellule = personnage.getCellule();
		this.force = personnage.getForce();
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
