package fr.sam.core.world.manager;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import fr.sam.core.world.Brique;
import fr.sam.core.world.EZebraSpriteType;
import fr.sam.core.world.Mur;
import fr.sam.core.world.TileInfo;
import fr.sam.core.world.Zebra;
import fr.sam.core.world.ZebraSprite;
import fr.sam.core.world.ZebraWorld;

public class ZebraSpriteFactory {

	private static volatile ZebraSpriteFactory factory;

	private ZebraSpriteFactory() {
		super();
	}

	public static ZebraSpriteFactory getInstance() {
		if (factory == null) {
			synchronized (ZebraWorldMaker.class) {
				if (factory == null) {
					factory = new ZebraSpriteFactory();
				}
			}
		}
		return (factory);
	}

	public ZebraSprite create(EZebraSpriteType type, ZebraWorld zebraWorld, TileInfo tileInfo, TextureRegion region) {
		switch (type) {
		case BRIQUE:
			return new Brique(zebraWorld, tileInfo, region);
		case ZEBRA:
			return new Zebra(zebraWorld, tileInfo, region);
		default:
			return new Mur(zebraWorld, tileInfo, region);
		}
	}

}
