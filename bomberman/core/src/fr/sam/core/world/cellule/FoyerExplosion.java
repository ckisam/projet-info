package fr.sam.core.world.cellule;

import fr.sam.core.world.ETextureRessource;

public class FoyerExplosion extends Explosion {

	public FoyerExplosion(ZebraCellule cellule) {
		super(cellule, ETextureRessource.EXPLOSION_FOYER.getTexture());
	}

	@Override
	public void propagerExplosion() {
		int force = getForce();
		if (force > 0) {
			ZebraCellule cellule = getCellule();
			if (cellule.getCelluleGauche() != null) {
				SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleGauche());
				souffle.setDirection(EDirection.GAUCHE);
				souffle.setForce(force - 1);
				cellule.getCelluleGauche().gererNouvelleExplosion(souffle);
			}
			if (cellule.getCelluleDroit() != null) {
				SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleDroit());
				souffle.setDirection(EDirection.DROITE);
				souffle.setForce(force - 1);
				cellule.getCelluleDroit().gererNouvelleExplosion(souffle);
			}
			if (cellule.getCelluleHaut() != null) {
				SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleHaut());
				souffle.setDirection(EDirection.HAUT);
				souffle.setForce(force - 1);
				cellule.getCelluleHaut().gererNouvelleExplosion(souffle);
			}
			if (cellule.getCelluleBas() != null) {
				SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleBas());
				souffle.setDirection(EDirection.BAS);
				souffle.setForce(force - 1);
				cellule.getCelluleBas().gererNouvelleExplosion(souffle);
			}
		}
	}

}
