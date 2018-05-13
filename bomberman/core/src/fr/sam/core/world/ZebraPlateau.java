package fr.sam.core.world;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;

import fr.sam.core.ZebraConstantes;
import fr.sam.core.world.cellule.CelluleVide;
import fr.sam.core.world.cellule.ZebraCellule;
import fr.sam.core.world.personnage.ZebraHero;

/**
 * Ensemble des cases du jeu.
 * 
 * @author Samuel
 *
 */
public class ZebraPlateau {

	private final float tileWidth, tileHeight;
	private ZebraHero zebraHero;
	private final ZebraCellule[][] celluleTab;

	public ZebraPlateau(TiledMap tiledMap) {
		super();
		MapProperties prop = tiledMap.getProperties();
		this.celluleTab = new ZebraCellule[prop.get(ZebraConstantes.MAP_WIDTH_KEY, Integer.class)][prop
				.get(ZebraConstantes.MAP_HEIGHT_KEY, Integer.class)];
		this.tileWidth = prop.get(ZebraConstantes.TILE_WIDTH_KEY, Integer.class);
		this.tileHeight = prop.get(ZebraConstantes.TILE_HEIGHT_KEY, Integer.class);
		for (int i = 0; i < celluleTab.length; i++) {
			for (int j = 0; j < celluleTab[i].length; j++) {
				CelluleVide cellule = new CelluleVide();
				ajouterCellule(cellule, i, j);
			}
		}
	}

	public void ajouterCellule(ZebraCellule cellule, int i, int j) {
		if (cellule == null) {
			return;
		}
		int maxI = celluleTab.length, maxJ = 0;
		if (maxI > 0) {
			maxJ = celluleTab[0].length;
		}
		if (i >= 0 && i < maxI && j >= 0 && j < maxJ) {
			celluleTab[i][j] = cellule;
			cellule.placer(this, i, j);
			cellule.reinitVoisins();
			if (i - 1 >= 0) {
				cellule.setCelluleGauche(celluleTab[i - 1][j]);
				if (celluleTab[i - 1][j] != null) {
					celluleTab[i - 1][j].setCelluleDroit(cellule);
				}
				if (j - 1 >= 0) {
					cellule.setCelluleBasGauche(celluleTab[i - 1][j - 1]);
					if (celluleTab[i - 1][j - 1] != null) {
						celluleTab[i - 1][j - 1].setCelluleHautDroit(cellule);
					}
				}
				if (j + 1 < maxJ) {
					cellule.setCelluleHautGauche(celluleTab[i - 1][j + 1]);
					if (celluleTab[i - 1][j + 1] != null) {
						celluleTab[i - 1][j + 1].setCelluleBasDroit(cellule);
					}
				}
			}
			if (i + 1 < maxI) {
				cellule.setCelluleDroit(celluleTab[i + 1][j]);
				if (celluleTab[i + 1][j] != null) {
					celluleTab[i + 1][j].setCelluleGauche(cellule);
				}
				if (j - 1 >= 0) {
					cellule.setCelluleBasDroit(celluleTab[i + 1][j - 1]);
					if (celluleTab[i + 1][j - 1] != null) {
						celluleTab[i + 1][j - 1].setCelluleHautGauche(cellule);
					}
				}
				if (j + 1 < maxJ) {
					cellule.setCelluleHautDroit(celluleTab[i + 1][j + 1]);
					if (celluleTab[i + 1][j + 1] != null) {
						celluleTab[i + 1][j + 1].setCelluleBasGauche(cellule);
					}
				}
			}
			if (j - 1 >= 0) {
				cellule.setCelluleBas(celluleTab[i][j - 1]);
				if (celluleTab[i][j - 1] != null) {
					celluleTab[i][j - 1].setCelluleHaut(cellule);
				}
			}
			if (j + 1 < maxJ) {
				cellule.setCelluleHaut(celluleTab[i][j + 1]);
				if (celluleTab[i][j + 1] != null) {
					celluleTab[i][j + 1].setCelluleBas(cellule);
				}
			}
		}

	}

	public void ajouterHero(ZebraHero zebraHero, int i, int j) {
		this.zebraHero = zebraHero;
		this.zebraHero.setCellule(celluleTab[i][j]);
		this.zebraHero.updatePosition();
	}

	public void renderPlateau(Batch batch) {
		batch.begin();
		for (int i = 0; i < this.celluleTab.length; i++) {
			for (int j = 0; j < this.celluleTab[i].length; j++) {
				ZebraCellule cellule = this.celluleTab[i][j];
				if (cellule != null) {
					cellule.render(batch);
				}
			}
		}
		if (zebraHero != null) {
			zebraHero.render(batch);
		}
		batch.end();
	}

	// Getters et setters

	public ZebraHero getZebraHero() {
		return zebraHero;
	}

	public void setZebraHero(ZebraHero zebraHero) {
		this.zebraHero = zebraHero;
	}

	public float getTileWidth() {
		return tileWidth;
	}

	public float getTileHeight() {
		return tileHeight;
	}

	public ZebraCellule[][] getCelluleTab() {
		return celluleTab;
	}

}
