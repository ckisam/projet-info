package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;

import fr.sam.core.world.manager.NumberGenerator;

/**
 * Case 'brique' : destructible par une bombe.
 * 
 * @author Samuel
 *
 */
public class BriqueCellule extends ZebraCellule {

	public BriqueCellule(Texture texture) {
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
		return true;
	}

	@Override
	public void gererFinExplosion() {
		this.setExplosion(null);
		if (isSortie()) {
			SortieCellule sortie = new SortieCellule();
			this.getPlateau().ajouterCellule(new CelluleVide(), getPosX(), getPosY());
			this.getPlateau().ajouterCellule(sortie, getPosX(), getPosY());
		} else {
			CelluleVide nouvelleCellule = new CelluleVide();
			this.getPlateau().ajouterCellule(nouvelleCellule, getPosX(), getPosY());
			int random = NumberGenerator.getInstance().tireEntreMinEtMax(1, 10);
			if (random == 10) {
				nouvelleCellule.setBonus(new Bonus(nouvelleCellule, EBonus.VIE));
			} else if (random < 10 && random > 5) {
				nouvelleCellule.setBonus(new Bonus(nouvelleCellule, EBonus.FORCE));
			}
		}
	}

}
