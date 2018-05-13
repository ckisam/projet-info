package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;

/**
 * Case 'mur' : le joueur ne peut la traverser et elle ne peut être détruite par
 * une bombe.
 * 
 * @author Samuel
 *
 */
public class MurCellule extends ZebraCellule {

	public MurCellule(Texture texture) {
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
		return false;
	}

}
