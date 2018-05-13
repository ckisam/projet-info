package fr.sam.core.world.personnage;

import com.badlogic.gdx.graphics.Texture;

import fr.sam.core.world.EEtatJeu;
import fr.sam.core.world.cellule.Bombe;
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
			Bombe bombe = new Bombe(cellule);
			cellule.setBombe(bombe);
			bombe.enclencher();
		}
	}

	@Override
	protected synchronized void bouger() {
		ZebraCellule cellule = getCellule();
		if (cellule instanceof SortieCellule) {
			cellule.getPlateau().getZebraWorld().setEtatJeu(EEtatJeu.GAGNE);
		}
		super.bouger();
	}

}
