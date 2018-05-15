package fr.sam.core.screen;

import java.lang.reflect.Constructor;

import com.badlogic.gdx.graphics.Texture;

import fr.sam.core.world.ZebraSprite;
import fr.sam.core.world.cellule.BriqueCellule;
import fr.sam.core.world.cellule.MurCellule;
import fr.sam.core.world.cellule.SortieCellule;
import fr.sam.core.world.cellule.ZebraMechant;
import fr.sam.core.world.personnage.ZebraHero;

/**
 * Différentes couches de carte carroyée (Tiled Map) qu'est capable de
 * comprendre le jeu.
 * 
 * @author Samuel
 *
 */
public enum EZebraLayerType {

	MUR("Murs", "Mur", MurCellule.class), //
	BRIQUES("Briques", "Brique", BriqueCellule.class), //
	HERO("Zebra", "Zebra", ZebraHero.class), //
	SORTIE("Sortie", "Sortie", SortieCellule.class), //
	MECHANT("Mechants", "Mechant", ZebraMechant.class);

	private final String layerName;
	private final String tileName;
	private final Class<? extends ZebraSprite> implementation;

	private EZebraLayerType(String layerName, String tileName, Class<? extends ZebraSprite> implementation) {
		this.layerName = layerName;
		this.tileName = tileName;
		this.implementation = implementation;
	}

	public ZebraSprite instantiate(Texture texture) {
		try {
			Constructor<? extends ZebraSprite> constructor = this.implementation.getDeclaredConstructor(Texture.class);
			return constructor.newInstance(texture);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Getters et setters

	public String getLayerName() {
		return layerName;
	}

	public String getTileName() {
		return tileName;
	}

	public Class<? extends ZebraSprite> getImplementation() {
		return implementation;
	}

}
