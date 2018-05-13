package fr.sam.core.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import fr.sam.core.ZebraConstantes;
import fr.sam.core.world.ZebraWorld;

/**
 * Menu de l'écran de jeu, placé à droite.
 * 
 * @author Samuel
 *
 */
public class MenuEcranJeu extends Stage {

	private Table fondMenuFrontiere;
	private Table fondMenu;
	private Table boutonBombeMenuFrontiere;
	private Table boutonBombeMenu;

	public MenuEcranJeu(final ZebraWorld zebraWorld) {
		super(new ScreenViewport());

		fondMenuFrontiere = new Table();
		fondMenuFrontiere.setBackground(new BackgroundColor(new Color(0x596877ff)));
		fondMenuFrontiere.setDebug(ZebraConstantes.DEBUG_MODE);
		addActor(fondMenuFrontiere);

		fondMenu = new Table();
		fondMenu.setBackground(new BackgroundColor(new Color(0x778899ff)));
		fondMenu.setDebug(ZebraConstantes.DEBUG_MODE);
		addActor(fondMenu);

		boutonBombeMenuFrontiere = new Table();
		boutonBombeMenuFrontiere.setBackground(new BackgroundColor(new Color(0x596877ff)));
		boutonBombeMenuFrontiere.setDebug(ZebraConstantes.DEBUG_MODE);
		addActor(boutonBombeMenuFrontiere);

		boutonBombeMenu = new Table();
		boutonBombeMenu.setBackground(new BackgroundColor(new Color(0xb1bbc5ff)));
		boutonBombeMenu.setDebug(ZebraConstantes.DEBUG_MODE);
		addActor(boutonBombeMenu);

		ImageButton boutonBombe = new BoutonBombe();
		boutonBombeMenu.add(boutonBombe);
		boutonBombe.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				zebraWorld.getPlateau().getZebraHero().poserBombe();
			}
		});

		// On ajuste la taille :
		dimensionnerElements();

	}

	public void redimensionner(int width, int height) {
		getViewport().update(width, height, true);
		dimensionnerElements();
	}

	private void dimensionnerElements() {
		// Fond du menu :
		int fondMenuWidth = 4 + ZebraConstantes.RIGHT_MENU_SIZE + 2 * ZebraConstantes.RIGHT_MENU_MARGIN;
		fondMenuFrontiere.setX(getWidth() - fondMenuWidth - 2);
		fondMenuFrontiere.setY(0);
		fondMenuFrontiere.setWidth(fondMenuWidth + 2);
		fondMenuFrontiere.setHeight(getHeight());
		fondMenu.setX(getWidth() - fondMenuWidth);
		fondMenu.setY(0);
		fondMenu.setWidth(fondMenuWidth);
		fondMenu.setHeight(getHeight());

		// Le bouton bombe :
		int bombeX = 2 + ZebraConstantes.RIGHT_MENU_SIZE + ZebraConstantes.RIGHT_MENU_MARGIN;
		boutonBombeMenuFrontiere.setX(getWidth() - bombeX - 2);
		boutonBombeMenuFrontiere.setY(ZebraConstantes.RIGHT_MENU_MARGIN - 2);
		boutonBombeMenuFrontiere.setWidth(ZebraConstantes.RIGHT_MENU_SIZE + 4);
		boutonBombeMenuFrontiere.setHeight(ZebraConstantes.RIGHT_MENU_SIZE + 4);
		boutonBombeMenu.setX(getWidth() - bombeX);
		boutonBombeMenu.setY(ZebraConstantes.RIGHT_MENU_MARGIN);
		boutonBombeMenu.setWidth(ZebraConstantes.RIGHT_MENU_SIZE);
		boutonBombeMenu.setHeight(ZebraConstantes.RIGHT_MENU_SIZE);
	}

}
