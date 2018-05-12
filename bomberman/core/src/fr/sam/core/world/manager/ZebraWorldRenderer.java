package fr.sam.core.world.manager;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import fr.sam.core.world.ZebraWorld;

public class ZebraWorldRenderer extends OrthogonalTiledMapRenderer {

	private ZebraWorld zebraWorld;
	private Batch batch;

	public ZebraWorldRenderer(ZebraWorld zebraWorld, Batch batch) {
		super(zebraWorld.getTiledMap(), batch);
		this.zebraWorld = zebraWorld;
		this.batch = batch;
	}

	@Override
	public void render() {
		super.render();
		zebraWorld.renderWorld(batch);
	}

}
