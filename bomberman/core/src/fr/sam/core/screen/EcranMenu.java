package fr.sam.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import fr.sam.core.BombaZebra;
import fr.sam.core.ZebraConstantes;

public class EcranMenu implements Screen {

	private final BombaZebra bombaZebra;
	private Stage stage;
	private TextButton boutonJouer;
	private TextButton boutonQuitter;

	public EcranMenu(final BombaZebra bombaZebra) {
		this.bombaZebra = bombaZebra;

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(ZebraConstantes.DEBUG_MODE);
		stage.addActor(table);

		Skin skin = new Skin(Gdx.files.internal("skin/comic-ui.json"));
		boutonJouer = new TextButton("Jouer", skin);
		boutonQuitter = new TextButton("Quitter", skin);

		table.add(boutonJouer).fillX().uniformX();
		table.row().pad(10, 0, 10, 0);
		table.add(boutonQuitter).fillX().uniformX();
		// table.add(boutonJouer);
		// table.add(boutonJouer);
		// table.row().pad(10, 0, 10, 0);
		// table.add(boutonJouer);
		// table.add(boutonJouer);
		// table.add(boutonJouer);
		// table.row();
		// table.add(boutonJouer);
		// table.row();
		// table.add(boutonQuitter).fillX().uniformX();
	}

	@Override
	public void show() {
		boutonQuitter.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
		boutonJouer.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				bombaZebra.setScreen(new EcranJeu(bombaZebra));
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
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
		stage.dispose();
	}

}
