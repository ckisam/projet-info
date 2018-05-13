package fr.sam.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import fr.sam.core.BombaZebra;
import fr.sam.core.ETextureRessource;
import fr.sam.core.ZebraConstantes;

/**
 * Ecran du menu principal, ouvert au lancement du jeu.
 * 
 * @author Samuel
 *
 */
public class EcranMenu implements Screen {

	private final BombaZebra bombaZebra;
	private Stage stage;
	private TextButton boutonJouer;
	private TextButton boutonQuitter;

	public EcranMenu(final BombaZebra bombaZebra) {
		this.bombaZebra = bombaZebra;

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		Table mainTable = new Table();
		mainTable.setFillParent(true);
		mainTable.setDebug(ZebraConstantes.DEBUG_MODE);
		stage.addActor(mainTable);

		// Skin skin = ESkinRessource.COMIC.getSkin();
		Skin skin = new Skin(Gdx.files.internal("skin/comic-ui.json"));
		boutonJouer = new TextButton("Jouer", skin);
		boutonQuitter = new TextButton("Quitter", skin);

		// On place les composants
		Table componentTable = new Table();
		componentTable.setBackground(new BackgroundColor(new Color(0x8f8f8fff)));
		componentTable.row().pad(10, 10, 0, 10);
		componentTable.add(new Image(ETextureRessource.ZEBRE_ACCUEIL.getTexture()));
		Label label = new Label("BombaZebra", skin);
		label.setAlignment(Align.center);
		componentTable.row().pad(0, 10, 25, 10);
		componentTable.add(label).fillX().uniformX();
		componentTable.row().pad(10, 10, 10, 10);
		componentTable.add(boutonJouer).fillX().uniformX();
		componentTable.row().pad(0, 10, 10, 10);
		componentTable.add(boutonQuitter).fillX().uniformX();

		Table borderTable = new Table();
		borderTable.setBackground(new BackgroundColor(new Color(0x696969ff)));
		borderTable.row().pad(2, 2, 2, 2);
		borderTable.add(componentTable);
		mainTable.row();
		mainTable.add(borderTable);
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
				bombaZebra.setScreen(new EcranChoixNiveau(bombaZebra));
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
