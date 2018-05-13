package fr.sam.core.world.personnage;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import fr.sam.core.world.ZebraSprite;
import fr.sam.core.world.cellule.ZebraCellule;

/**
 * Personnage pouvant évoluer au sein de l'univers de jeu.
 * 
 * @author Samuel
 *
 */
public class ZebraPersonnage extends ZebraSprite {

	private static final int UPDATE_DELAY = 100;
	private static final int NB_STEP = 4;

	private volatile long nanoTime = System.nanoTime();

	private ZebraCellule cellule;
	private int verStep = 0, horStep = 0;
	private int vitesseX = 0, vitesseY = 0;

	public ZebraPersonnage() {
		super();
	}

	public ZebraPersonnage(Texture texture) {
		super(texture);
	}

	public void updatePosition() {
		float xStep = ((float) horStep) / ((float) NB_STEP);
		float yStep = ((float) verStep) / ((float) NB_STEP);
		float newX = (((float) cellule.getPosX()) + xStep) * cellule.getPlateau().getTileWidth();
		float newY = (((float) cellule.getPosY()) + yStep) * cellule.getPlateau().getTileHeight();
		this.setPosition(newX, newY);
	}

	@Override
	public void render(Batch batch) {
		bouger();
		this.draw(batch);
	}

	private synchronized void bouger() {
		long timeDiff = System.nanoTime() - nanoTime;
		if (TimeUnit.MILLISECONDS.convert(timeDiff, TimeUnit.NANOSECONDS) > UPDATE_DELAY) {
			if (!(vitesseX == 0 && vitesseY == 0)) {
				if (vitesseX < 0) {
					bougerGauche();
				} else if (vitesseX > 0) {
					bougerDroite();
				}
				if (vitesseY < 0) {
					bougerBas();
				} else if (vitesseY > 0) {
					bougerHaut();
				}
				updatePosition();
			}
			nanoTime = System.nanoTime();
		}
	}

	private void bougerGauche() {
		if (horStep == 0 && cellule.getCelluleGauche().accessible()) {
			if (verStep == 0 || cellule.getCelluleHautGauche().accessible()) {
				horStep = NB_STEP - 1;
				cellule = cellule.getCelluleGauche();
			}
		} else if (horStep > 0) {
			horStep -= 1;
		} else {
			vitesseX = 0;
		}
	}

	private void bougerDroite() {
		if (horStep == NB_STEP - 1) {
			horStep = 0;
			cellule = cellule.getCelluleDroit();
		} else if (horStep > 0 && horStep < NB_STEP - 1) {
			horStep += 1;
		} else if (horStep == 0 && cellule.getCelluleDroit().accessible()) {
			if (verStep == 0 || cellule.getCelluleHautDroit().accessible()) {
				horStep += 1;
			}
		} else {
			vitesseX = 0;
		}
	}

	private void bougerHaut() {
		if (verStep == NB_STEP - 1) {
			verStep = 0;
			cellule = cellule.getCelluleHaut();
		} else if (verStep > 0 && verStep < NB_STEP - 1) {
			verStep += 1;
		} else if (verStep == 0 && cellule.getCelluleHaut().accessible()) {
			if (horStep == 0 || cellule.getCelluleHautDroit().accessible()) {
				verStep += 1;
			}
		} else {
			vitesseY = 0;
		}
	}

	private void bougerBas() {
		if (verStep == 0 && cellule.getCelluleBas().accessible()) {
			if (horStep == 0 || cellule.getCelluleBasDroit().accessible()) {
				verStep = NB_STEP - 1;
				cellule = cellule.getCelluleBas();
			}
		} else if (verStep > 0) {
			verStep -= 1;
		} else {
			vitesseY = 0;
		}
	}

	// Getters et setters

	public ZebraCellule getCellule() {
		return cellule;
	}

	public void setCellule(ZebraCellule cellule) {
		this.cellule = cellule;
	}

	public int getVerStep() {
		return verStep;
	}

	public void setVerStep(int verStep) {
		this.verStep = verStep;
	}

	public int getHorStep() {
		return horStep;
	}

	public void setHorStep(int horStep) {
		this.horStep = horStep;
	}

	public int getVitesseX() {
		return vitesseX;
	}

	public void setVitesseX(int vitesseX) {
		this.vitesseX = vitesseX;
	}

	public int getVitesseY() {
		return vitesseY;
	}

	public void setVitesseY(int vitesseY) {
		this.vitesseY = vitesseY;
	}

}
