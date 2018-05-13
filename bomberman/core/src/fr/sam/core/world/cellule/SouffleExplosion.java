package fr.sam.core.world.cellule;

import fr.sam.core.ETextureRessource;

public class SouffleExplosion extends Explosion {

	private EDirection direction;

	public SouffleExplosion(ZebraCellule cellule) {
		super(cellule, ETextureRessource.EXPLOSION.getTexture());
	}

	@Override
	public void propagerExplosion() {
		int force = getForce();
		if (force > 0) {
			ZebraCellule cellule = getCellule();
			switch (direction) {
			case GAUCHE:
				if (cellule.getCelluleGauche() != null) {
					SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleGauche());
					souffle.setDirection(EDirection.GAUCHE);
					souffle.setForce(force - 1);
					cellule.getCelluleGauche().gererNouvelleExplosion(souffle);
				}
				break;
			case DROITE:
				if (cellule.getCelluleDroit() != null) {
					SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleDroit());
					souffle.setDirection(EDirection.DROITE);
					souffle.setForce(force - 1);
					cellule.getCelluleDroit().gererNouvelleExplosion(souffle);
				}
				break;
			case HAUT:
				if (cellule.getCelluleHaut() != null) {
					SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleHaut());
					souffle.setDirection(EDirection.HAUT);
					souffle.setForce(force - 1);
					cellule.getCelluleHaut().gererNouvelleExplosion(souffle);
				}
				break;
			case BAS:
				if (cellule.getCelluleBas() != null) {
					SouffleExplosion souffle = new SouffleExplosion(cellule.getCelluleBas());
					souffle.setDirection(EDirection.BAS);
					souffle.setForce(force - 1);
					cellule.getCelluleBas().gererNouvelleExplosion(souffle);
				}
				break;
			default:
				break;
			}
		}
	}

	// Getters et setters

	public EDirection getDirection() {
		return direction;
	}

	public void setDirection(EDirection direction) {
		this.direction = direction;
	}

}
