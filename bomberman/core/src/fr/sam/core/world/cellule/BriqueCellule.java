package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;

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
		CelluleVide nouvelleCellule = new CelluleVide();
		this.getPlateau().ajouterCellule(nouvelleCellule, getPosX(), getPosY());
		// TODO Gerer les bonus :) (enfin !!)
	}

}
