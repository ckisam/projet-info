package fr.sam.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import fr.sam.core.BombaZebra;
import fr.sam.core.ZebraConstantes;

/**
 * Ecran de fin de jeu, lorsque la partie est gagnée :)
 * 
 * @author Samuel
 *
 */
public class EcranFinJeuGagne implements Screen {

	private final BombaZebra bombaZebra;
	private Stage stage;
	private TextButton boutonMenuPrincipal;
	private TextButton boutonContinuer;

	public EcranFinJeuGagne(final BombaZebra bombaZebra) {
		this.bombaZebra = bombaZebra;

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		Table table = new Table();
		table.setFillParent(true);
		table.setDebug(ZebraConstantes.DEBUG_MODE);
		table.setBackground(new BackgroundColor(new Color(0xC0C0C0ff)));
		stage.addActor(table);

		Skin skin = new Skin(Gdx.files.internal("skin/comic-ui.json"));
		Label label = new Label("Bravo, tu as fini le niveau !", skin);
		label.setAlignment(Align.center);
		boutonMenuPrincipal = new TextButton("Menu principal", skin);
		boutonContinuer = new TextButton("Continuer", skin);

		// On place les composants
		table.row().pad(10, 10, 10, 10);
		table.add(label).colspan(2).fillX().uniformX();
		table.row().pad(10, 10, 10, 10);
		table.add(boutonMenuPrincipal).fillX().uniformX();
		table.add(boutonContinuer).fillX().uniformX();
	}

	@Override
	public void show() {
		boutonContinuer.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				bombaZebra.setScreen(new EcranChoixNiveau(bombaZebra));
			}
		});
		boutonMenuPrincipal.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				bombaZebra.setScreen(new EcranMenu(bombaZebra));
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
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
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}
