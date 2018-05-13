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
import fr.sam.core.ENiveauJeu;
import fr.sam.core.ZebraConstantes;

/**
 * Ecran permettant de choisir un niveau de jeu.
 * 
 * @author Samuel
 *
 */
public class EcranChoixNiveau implements Screen {

	final BombaZebra bombaZebra;
	private Stage stage;

	public EcranChoixNiveau(final BombaZebra bombaZebra) {
		this.bombaZebra = bombaZebra;

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		Table mainTable = new Table();
		mainTable.setFillParent(true);
		mainTable.setDebug(ZebraConstantes.DEBUG_MODE);
		stage.addActor(mainTable);

		Skin skin = new Skin(Gdx.files.internal("skin/comic-ui.json"));
		ENiveauJeu[] niveauTab = ENiveauJeu.values();
		int nb = niveauTab.length;
		mainTable.row();
		for (int i = 0; i < nb; i++) {
			final ENiveauJeu niveau = niveauTab[i];
			if (i > 0 && i % 3 == 0) {
				mainTable.row();
			}
			TextButton button = new TextButton("Niveau " + niveau.getRang(), skin);
			button.addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					bombaZebra.setScreen(new EcranJeu(bombaZebra, niveau));
				}
			});
			mainTable.add(button);
		}
	}

	@Override
	public void show() {
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
