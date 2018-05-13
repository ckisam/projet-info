package fr.sam.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import fr.sam.core.BombaZebra;
import fr.sam.core.ENiveauJeu;
import fr.sam.core.ZebraConstantes;
import fr.sam.core.world.ZebraWorld;
import fr.sam.core.world.manager.ZebraWorldInputProcessor;
import fr.sam.core.world.manager.ZebraWorldMaker;
import fr.sam.core.world.manager.ZebraWorldRenderer;

/**
 * Ecran de jeu, avec la carte du niveau et le menu à droite.
 * 
 * @author Samuel
 *
 */
public class EcranJeu implements Screen {

	private final BombaZebra bombaZebra;
	private ZebraOrthographicCamera camera;
	private ZebraWorldRenderer zebraWorldRenderer;
	private ZebraWorld zebraWorld;

	// Les boutons
	private MenuEcranJeu menu;

	// Mode Debug
	private Box2DDebugRenderer debugRenderer;

	public EcranJeu(final BombaZebra bombaZebra, ENiveauJeu niveau) {
		this.bombaZebra = bombaZebra;

		TiledMap tiledMap = niveau.getTiledMap();
		this.zebraWorld = ZebraWorldMaker.getInstance().make(tiledMap);
		this.camera = new ZebraOrthographicCamera(zebraWorld);
		this.camera.setToOrtho();
		this.zebraWorldRenderer = new ZebraWorldRenderer(zebraWorld, bombaZebra.getBatch());

		// Les boutons
		menu = new MenuEcranJeu(zebraWorld);

		// Ajout du mouvement
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(new ZebraWorldInputProcessor(zebraWorld));
		multiplexer.addProcessor(menu);
		Gdx.input.setInputProcessor(multiplexer);

		// Pour le mode debug
		this.debugRenderer = new Box2DDebugRenderer();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.resize();
		camera.update();
		zebraWorldRenderer.setView(camera);
		zebraWorldRenderer.render();

		// Les boutons
		menu.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		menu.draw();

		// Mode debug
		if (ZebraConstantes.DEBUG_MODE) {
			debugRenderer.render(zebraWorld.getWorld(), camera.combined);
		}

		// Condition de fin
		switch (zebraWorld.getEtatJeu()) {
		case GAGNE:
			dispose();
			bombaZebra.setScreen(new EcranFinJeuGagne(bombaZebra));
			break;
		case PERDU:
			dispose();
			bombaZebra.setScreen(new EcranFinJeuPerdu(bombaZebra));
			break;
		default:
			break;
		}
	}

	@Override
	public void show() {
	}

	@Override
	public void resize(int width, int height) {
		camera.resize();
		menu.redimensionner(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
