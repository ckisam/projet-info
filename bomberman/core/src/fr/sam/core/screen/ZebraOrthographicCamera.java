package fr.sam.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector3;

public class ZebraOrthographicCamera extends OrthographicCamera {

	private TiledMapInfo mapInfo;

	public ZebraOrthographicCamera(TiledMap tiledMap) {
		super();
		this.mapInfo = new TiledMapInfo(tiledMap);
	}

	public void setToOrtho() {
		resize();
		super.setToOrtho(false, this.viewportWidth, this.viewportHeight);
	}

	public void resize() {
		int ecranWidth = Gdx.graphics.getWidth();
		int ecranHeight = Gdx.graphics.getHeight();
		int mapWidth = mapInfo.getWidth();
		int mapHeight = mapInfo.getHeight();
		float width = ecranWidth;
		float height = ecranHeight;
		if (ecranWidth > mapWidth && ecranHeight > mapHeight) {
			// TODO
			Vector3 pos = this.position;
			this.position.set(mapWidth / 2, mapHeight / 2, 0);
		}
		this.viewportWidth = ecranWidth;
		this.viewportHeight = ecranHeight;
	}

}
