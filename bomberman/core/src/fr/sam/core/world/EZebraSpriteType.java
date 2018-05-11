package fr.sam.core.world;

public enum EZebraSpriteType {

	ZEBRA("Zebra", "Zebra", Zebra.class), //
	MUR("Murs", "Mur", Mur.class), //
	BRIQUE("Briques", "Brique", Brique.class);

	private final String layerName;
	private final String tileName;
	private final Class<? extends ZebraSprite> implementation;

	private EZebraSpriteType(String layerName, String tileName, Class<? extends ZebraSprite> classe) {
		this.layerName = layerName;
		this.tileName = tileName;
		this.implementation = classe;
	}

	public static final String getUserData(Object obj) {
		if (obj != null) {
			EZebraSpriteType typeFound = getTypeFromClass(obj.getClass());
			if (typeFound != null) {
				return typeFound.layerName;
			}
		}
		return "";
	}

	public static final EZebraSpriteType getTypeFromClass(Class<?> classe) {
		for (EZebraSpriteType type : EZebraSpriteType.values()) {
			if (type.implementation.equals(classe)) {
				return type;
			}
		}
		return null;
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
