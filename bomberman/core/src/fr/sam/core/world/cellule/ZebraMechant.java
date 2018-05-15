package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;

import fr.sam.core.world.manager.NumberGenerator;
import fr.sam.core.world.personnage.ZebraPersonnage;

/**
 * Les méchants : attention, ils peuvent tuer notre héro ! :(
 * 
 * @author Samuel
 *
 */
public class ZebraMechant extends ZebraPersonnage {

	private boolean vivant = true;

	public ZebraMechant(Texture texture) {
		super(texture);
	}

	@Override
	public void gererMort() {
		this.vivant = false;
	}

	@Override
	protected synchronized void bouger() {
		ZebraCellule cellule = getCellule();
		ZebraCellule heroCellule = cellule.getPlateau().getZebraHero().getCellule();
		if (heroCellule.getPosX() == cellule.getPosX()) {
			if (heroCellule.getPosY() > cellule.getPosY()) {
				setVitesseY(1);
			} else if (heroCellule.getPosY() < cellule.getPosY()) {
				setVitesseY(-1);
			}
			setVitesseX(0);
		}
		if (heroCellule.getPosY() == cellule.getPosY()) {
			if (heroCellule.getPosX() > cellule.getPosX()) {
				setVitesseX(1);
			} else if (heroCellule.getPosX() < cellule.getPosX()) {
				setVitesseX(-1);
			}
			setVitesseY(0);
		}
		if (getVitesseX() == 0 && getVitesseY() == 0) {
			int alea = NumberGenerator.getInstance().tireEntreMinEtMax(0, 2);
			if (alea == 0) {
				setVitesseX(1);
			} else if (alea == 2) {
				setVitesseX(-1);
			}
			alea = NumberGenerator.getInstance().tireEntreMinEtMax(0, 2);
			if (alea == 0) {
				setVitesseY(1);
			} else if (alea == 2) {
				setVitesseY(-1);
			}
		}
		super.bouger();
	}

	// Getters et setters

	public boolean isVivant() {
		return vivant;
	}

	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}

}
