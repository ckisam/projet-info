package fr.sam.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

import fr.sam.core.ZebraConstantes;
import fr.sam.core.world.ZebraWorld;

/**
 * Camera permettant d'afficher le jeu. S'adapte � la position du joueur.
 * 
 * @author Samuel
 *
 */
public class ZebraOrthographicCamera extends OrthographicCamera {

	private ZebraWorld zebraWorld;
	private TiledMapInfo mapInfo;

	public ZebraOrthographicCamera(ZebraWorld zebraWorld) {
		super();
		this.zebraWorld = zebraWorld;
		this.mapInfo = new TiledMapInfo(zebraWorld.getTiledMap());
	}

	public void setToOrtho() {
		resize();
		super.setToOrtho(false, this.viewportWidth, this.viewportHeight);
	}

	/**
	 * <p>
	 * M�thode importante : permet de positionner correctement la cam�ra �tant donn�
	 * la taille de l'�cran, la taille de la carte et la position du joueur sur la
	 * carte.
	 * </p>
	 * <p>
	 * R�gle de gestion : si la carte est contenable dans l'�cran, elle est centr�e.
	 * Sinon, la camera est centr� sur le joueur, sauf s'il est trop proche d'un
	 * bord.
	 * </p>
	 */
	public void resize() {
		// On r�cup�re les infos
		int ecranWidth = Gdx.graphics.getWidth();
		int ecranHeight = Gdx.graphics.getHeight();
		int menuWidth = 4 + ZebraConstantes.RIGHT_MENU_SIZE //
				+ 2 * ZebraConstantes.RIGHT_MENU_MARGIN;
		int menuHeight = 0;
		int realWidth = ecranWidth - menuWidth;
		int realHeight = ecranHeight;
		int mapWidth = mapInfo.getWidth();
		int mapHeight = mapInfo.getHeight();

		// On adapte � la taille de la carte et � la position du joueur
		float camX = (mapWidth + menuWidth) / 2, camY = (mapHeight + menuHeight) / 2;
		float heroX = zebraWorld.getPlateau().getZebraHero().getX(),
				heroY = zebraWorld.getPlateau().getZebraHero().getY();
		if (realWidth < mapWidth) {
			if (heroX > realWidth / 2) {
				if (heroX < mapWidth - (realWidth / 2)) {
					camX = heroX + (menuWidth / 2);
				} else {
					camX = mapWidth - (ecranWidth / 2) + menuWidth;
				}
			} else {
				camX = ecranWidth / 2;
			}
		}
		if (realHeight < mapHeight) {
			if (heroY > realHeight / 2) {
				if (heroY < mapHeight - (realHeight / 2)) {
					camY = heroY + (menuHeight / 2);
				} else {
					camY = mapHeight - (ecranHeight / 2) + menuHeight;
				}
			} else {
				camY = ecranHeight / 2;
			}
		}
		this.position.set(camX, camY, 0);

		// On met � jour
		this.viewportWidth = ecranWidth;
		this.viewportHeight = ecranHeight;
	}

}
