package fr.sam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen {

	final Bomberman game;

	private Box2DDebugRenderer debugRenderer;
	private OrthographicCamera camera;
	private TiledMapReader mapReader;
	private World world;

	public GameScreen(final Bomberman game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
		camera.update();

		world = new World(new Vector2(0, GameConstants.GRAVITY), true);
		World.setVelocityThreshold(0.0f);
		debugRenderer = new Box2DDebugRenderer();

		TiledMap tiledMap = new TmxMapLoader().load("cartes/niveau1.tmx");
		OrthogonalTiledMapRendererWithSprites tiledMapRenderer = new OrthogonalTiledMapRendererWithSprites(tiledMap,
				GameConstants.MPP, game.batch);

		mapReader = new TiledMapReader(game, tiledMap, world, camera);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		world.step(GameConstants.BOX_STEP, GameConstants.BOX_VELOCITY_ITERATIONS,
				GameConstants.BOX_POSITION_ITERATIONS);
		debugRenderer.render(world, camera.combined);

		mapReader.hero.displacement();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

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