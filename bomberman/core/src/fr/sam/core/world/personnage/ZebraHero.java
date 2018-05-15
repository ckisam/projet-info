package fr.sam.core.world.personnage;

import com.badlogic.gdx.graphics.Texture;

import fr.sam.core.world.EEtatJeu;
import fr.sam.core.world.cellule.Bombe;
import fr.sam.core.world.cellule.Bonus;
import fr.sam.core.world.cellule.EBonus;
import fr.sam.core.world.cellule.SortieCellule;
import fr.sam.core.world.cellule.ZebraCellule;

/**
 * Personnage manipulé par le joueur.
 * 
 * @author Samuel
 *
 */
public class ZebraHero extends ZebraPersonnage {

	public ZebraHero(Texture texture) {
		super(texture);
	}

	public void poserBombe() {
		ZebraCellule cellule = getCellule();
		if (!cellule.estMinee()) {
			Bombe bombe = new Bombe(this);
			cellule.setBombe(bombe);
			bombe.enclencher();
		}
	}

	@Override
	protected synchronized void bouger() {
		ZebraCellule cellule = getCellule();
		// Si on est sur la sortie, c'est fini :)
		if (cellule instanceof SortieCellule) {
			cellule.getPlateau().getZebraWorld().setEtatJeu(EEtatJeu.GAGNE);
		}
		// On récupère le bonus éventuel
		if (cellule.aBonus()) {
			Bonus bonus = cellule.getBonus();
			if (bonus.getType() == EBonus.VIE) {
				setNbVie(getNbVie() + 1);
			}
			if (bonus.getType() == EBonus.FORCE) {
				setForce(getForce() + 1);
			}
			cellule.setBonus(null);
		}
		super.bouger();
	}

	@Override
	public void gererMort() {
		getCellule().getPlateau().getZebraWorld().setEtatJeu(EEtatJeu.PERDU);
	}

}
