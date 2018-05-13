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

public class MenuEcranJeu extends Stage {

	private ZebraWorld zebraWorld;

	private Table fondMenu;
	private Table boutonBombeMenu;

	public MenuEcranJeu(final ZebraWorld zebraWorld) {
		super(new ScreenViewport());

		this.zebraWorld = zebraWorld;

		this.fondMenu = new Table();
		// table.setFillParent(true);
		fondMenu.setDebug(ZebraConstantes.DEBUG_MODE);
		addActor(fondMenu);

		fondMenu.setBackground(new BackgroundColor(new Color(0x778899ff)));

		this.boutonBombeMenu = new Table();
		boutonBombeMenu.setDebug(ZebraConstantes.DEBUG_MODE);
		addActor(boutonBombeMenu);
		boutonBombeMenu.setBackground(new BackgroundColor(new Color(0x8f8f8fff)));
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
		System.out.println("Nouvelles dimensions : width = " + width + " - height = " + height);
		dimensionnerElements();
	}

	private void dimensionnerElements() {
		// Fond du menu :
		int fondMenuWidth = ZebraConstantes.RIGHT_MENU_SIZE + 2 * ZebraConstantes.RIGHT_MENU_MARGIN;
		fondMenu.setX(getWidth() - fondMenuWidth);
		fondMenu.setY(0);
		fondMenu.setWidth(fondMenuWidth);
		fondMenu.setHeight(getHeight());

		// Le bouton bombe :
		int bombeX = ZebraConstantes.RIGHT_MENU_SIZE + ZebraConstantes.RIGHT_MENU_MARGIN;
		boutonBombeMenu.setX(getWidth() - bombeX);
		boutonBombeMenu.setY(ZebraConstantes.RIGHT_MENU_MARGIN);
		boutonBombeMenu.setWidth(ZebraConstantes.RIGHT_MENU_SIZE);
		boutonBombeMenu.setHeight(ZebraConstantes.RIGHT_MENU_SIZE);
	}

}
