package fr.sam.core.world.cellule;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import fr.sam.core.world.ZebraSprite;

/**
 * Explosion suite au dépôt d'une bombe par le joueur.
 * 
 * @author Samuel
 *
 */
public abstract class Explosion extends ZebraSprite {

	private static final int TEMPS_EXPLOSION = 500;

	private ZebraCellule cellule;
	private int force;

	private boolean enCours;
	private long nanoTime;

	public Explosion(ZebraCellule cellule, Texture texture) {
		super(texture);
		this.cellule = cellule;
		setPosition(cellule.getX(), cellule.getY());
	}

	@Override
	public void render(Batch batch) {
		gererTempsExplosion();
		if (enCours) {
			this.draw(batch);
		}
	}

	public void demarrer() {
		this.enCours = true;
		this.nanoTime = System.nanoTime();
	}

	private void gererTempsExplosion() {
		long timeDiff = System.nanoTime() - nanoTime;
		if (TimeUnit.MILLISECONDS.convert(timeDiff, TimeUnit.NANOSECONDS) > TEMPS_EXPLOSION) {
			finirExplosion();
		}
	}

	private void finirExplosion() {
		this.enCours = false;
		this.cellule.gererFinExplosion();
	}

	public abstract void propagerExplosion();

	// Getters et setters

	public ZebraCellule getCellule() {
		return cellule;
	}

	public void setCellule(ZebraCellule cellule) {
		this.cellule = cellule;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

}
