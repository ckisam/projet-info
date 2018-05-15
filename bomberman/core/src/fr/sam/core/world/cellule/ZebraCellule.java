package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import fr.sam.core.world.ZebraPlateau;
import fr.sam.core.world.ZebraSprite;

/**
 * Définition standard d'une case du jeu.
 * 
 * @author Samuel
 *
 */
public abstract class ZebraCellule extends ZebraSprite {

	private ZebraPlateau plateau;
	private int posX, posY;
	private ZebraCellule celluleGauche;
	private ZebraCellule celluleHautGauche;
	private ZebraCellule celluleHaut;
	private ZebraCellule celluleHautDroit;
	private ZebraCellule celluleDroit;
	private ZebraCellule celluleBasDroit;
	private ZebraCellule celluleBas;
	private ZebraCellule celluleBasGauche;

	private Bombe bombe;
	private Explosion explosion;
	private Bonus bonus;
	private boolean sortie;

	public ZebraCellule() {
		super();
	}

	public ZebraCellule(Texture texture) {
		super(texture);
	}

	@Override
	public void render(Batch batch) {
		this.draw(batch);
		if (estMinee()) {
			bombe.render(batch);
		}
		if (explose()) {
			explosion.render(batch);
		}
		if (aBonus()) {
			bonus.render(batch);
		}
	}

	public void reinitVoisins() {
		setCelluleGauche(null);
		setCelluleHautGauche(null);
		setCelluleHaut(null);
		setCelluleHautDroit(null);
		setCelluleDroit(null);
		setCelluleBasDroit(null);
		setCelluleBas(null);
		setCelluleBasGauche(null);
	}

	public void placer(ZebraPlateau plateau, int i, int j) {
		this.plateau = plateau;
		this.posX = i;
		this.posY = j;
		updatePosition();
	}

	public void updatePosition() {
		float newX = ((float) posX) * plateau.getTileWidth();
		float newY = ((float) posY) * plateau.getTileHeight();
		this.setPosition(newX, newY);
	}

	public abstract boolean accessible();

	public abstract boolean bloqueExplosion();

	public abstract boolean accepteExplosion();

	public boolean estMinee() {
		return this.bombe != null;
	}

	public boolean explose() {
		return this.explosion != null;
	}

	public void enleverBombe() {
		this.bombe = null;
	}

	public void gererNouvelleExplosion(Explosion explosion) {
		if (accepteExplosion()) {
			this.explosion = explosion;
			explosion.demarrer();
			if (!bloqueExplosion()) {
				explosion.propagerExplosion();
			}
			// TODO que fait-on s'il y a deja une bombe par exemple ?
		}
	}

	public void gererFinExplosion() {
		this.explosion = null;
	}

	public void enleverBonus() {
		this.bonus = null;
	}

	public boolean aBonus() {
		return bonus != null;
	}

	// Getters et setters

	public ZebraPlateau getPlateau() {
		return plateau;
	}

	public void setPlateau(ZebraPlateau plateau) {
		this.plateau = plateau;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public ZebraCellule getCelluleGauche() {
		return celluleGauche;
	}

	public void setCelluleGauche(ZebraCellule celluleGauche) {
		this.celluleGauche = celluleGauche;
	}

	public ZebraCellule getCelluleHautGauche() {
		return celluleHautGauche;
	}

	public void setCelluleHautGauche(ZebraCellule celluleHautGauche) {
		this.celluleHautGauche = celluleHautGauche;
	}

	public ZebraCellule getCelluleHaut() {
		return celluleHaut;
	}

	public void setCelluleHaut(ZebraCellule celluleHaut) {
		this.celluleHaut = celluleHaut;
	}

	public ZebraCellule getCelluleHautDroit() {
		return celluleHautDroit;
	}

	public void setCelluleHautDroit(ZebraCellule celluleHautDroit) {
		this.celluleHautDroit = celluleHautDroit;
	}

	public ZebraCellule getCelluleDroit() {
		return celluleDroit;
	}

	public void setCelluleDroit(ZebraCellule celluleDroit) {
		this.celluleDroit = celluleDroit;
	}

	public ZebraCellule getCelluleBasDroit() {
		return celluleBasDroit;
	}

	public void setCelluleBasDroit(ZebraCellule celluleBasDroit) {
		this.celluleBasDroit = celluleBasDroit;
	}

	public ZebraCellule getCelluleBas() {
		return celluleBas;
	}

	public void setCelluleBas(ZebraCellule celluleBas) {
		this.celluleBas = celluleBas;
	}

	public ZebraCellule getCelluleBasGauche() {
		return celluleBasGauche;
	}

	public void setCelluleBasGauche(ZebraCellule celluleBasGauche) {
		this.celluleBasGauche = celluleBasGauche;
	}

	public Bombe getBombe() {
		return bombe;
	}

	public void setBombe(Bombe bombe) {
		this.bombe = bombe;
	}

	public Explosion getExplosion() {
		return explosion;
	}

	public void setExplosion(Explosion explosion) {
		this.explosion = explosion;
	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}

}
