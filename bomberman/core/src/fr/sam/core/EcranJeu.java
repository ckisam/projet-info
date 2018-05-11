package fr.sam.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import fr.sam.core.world.ZebraOrthographicCamera;
import fr.sam.core.world.ZebraWorld;
import fr.sam.core.world.ZebraWorldInputProcessor;
import fr.sam.core.world.manager.ZebraWorldMaker;

public class EcranJeu implements Screen {

	private final BombaZebra bombaZebra;
	private ZebraOrthographicCamera camera;
	private ZebraWorldRenderer zebraWorldRenderer;
	private ZebraWorld zebraWorld;

	// Mode Debug
	private Box2DDebugRenderer debugRenderer;

	public EcranJeu(final BombaZebra bombaZebra) {
		this.bombaZebra = bombaZebra;

		TiledMap tiledMap = new TmxMapLoader().load("cartes/niveau1.tmx");
		this.camera = new ZebraOrthographicCamera(tiledMap);
		this.camera.setToOrtho();
		this.zebraWorld = ZebraWorldMaker.getInstance().make(tiledMap);
		this.zebraWorldRenderer = new ZebraWorldRenderer(zebraWorld, bombaZebra.getBatch());

		// Ajout du mouvement
		Gdx.input.setInputProcessor(new ZebraWorldInputProcessor(zebraWorld));

		// Pour le mode debug
		this.debugRenderer = new Box2DDebugRenderer();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		// zebraWorld.getWorld().step(timeStep, velocityIterations, positionIterations);
		zebraWorld.getWorld().step(1 / 60f, 6, 2);
		zebraWorldRenderer.setView(camera);
		zebraWorldRenderer.render();

		// Mode debug
		if (ZebraConstantes.DEBUG_MODE) {
			debugRenderer.render(zebraWorld.getWorld(), camera.combined);
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		camera.resize();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
