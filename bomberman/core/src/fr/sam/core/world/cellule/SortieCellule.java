package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;

import fr.sam.core.ETextureRessource;

/**
 * Lorsque le joueur l'atteint, il a fini le niveau.
 * 
 * @author Samuel
 *
 */
public class SortieCellule extends ZebraCellule {

	public SortieCellule() {
		this(ETextureRessource.SORTIE.getTexture());
	}

	public SortieCellule(Texture texture) {
		super(texture);
	}

	@Override
	public boolean accessible() {
		return true;
	}

	@Override
	public boolean bloqueExplosion() {
		return false;
	}

	@Override
	public boolean accepteExplosion() {
		return true;
	}

	@Override
	public boolean isSortie() {
		// Cette case est une sortie, par définition
		return true;
	}

	@Override
	public void setSortie(boolean sortie) {
		// Cette case est une sortie par définition, on ne fait donc rien
	}

}
