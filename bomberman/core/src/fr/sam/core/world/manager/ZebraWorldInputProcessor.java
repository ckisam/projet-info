package fr.sam.core.world.manager;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

import fr.sam.core.world.ZebraWorld;

public class ZebraWorldInputProcessor implements InputProcessor {

	private ZebraWorld zebraWorld;
	private Map<Integer, TouchInfo> touchInfoMap = new HashMap<Integer, TouchInfo>();

	private class TouchInfo {
		int x = 0, y = 0;

		public TouchInfo(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public ZebraWorldInputProcessor(ZebraWorld zebraWorld) {
		super();
		this.zebraWorld = zebraWorld;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseY(1);
		} else if (keycode == Keys.DOWN) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseY(-1);
		} else if (keycode == Keys.LEFT) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseX(-1);
		} else if (keycode == Keys.RIGHT) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseX(1);
		} else if (keycode == Keys.SPACE) {
			this.zebraWorld.getPlateau().getZebraHero().poserBombe();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseY(0);
		} else if (keycode == Keys.DOWN) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseY(0);
		} else if (keycode == Keys.LEFT) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseX(0);
		} else if (keycode == Keys.RIGHT) {
			this.zebraWorld.getPlateau().getZebraHero().setVitesseX(0);
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touchInfoMap.put(pointer, new TouchInfo(screenX, screenY));
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		touchInfoMap.remove(pointer);
		this.zebraWorld.getPlateau().getZebraHero().setVitesseX(0);
		this.zebraWorld.getPlateau().getZebraHero().setVitesseY(0);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		TouchInfo touchInfo = touchInfoMap.get(pointer);
		int xDiff = screenX - touchInfo.x, yDiff = screenY - touchInfo.y;
		if (Math.abs(xDiff) > Math.abs(yDiff)) {
			if (xDiff < 0) {
				this.zebraWorld.getPlateau().getZebraHero().setVitesseX(-1);
			} else {
				this.zebraWorld.getPlateau().getZebraHero().setVitesseX(1);
			}
		} else {
			if (yDiff < 0) {
				this.zebraWorld.getPlateau().getZebraHero().setVitesseY(1);
			} else {
				this.zebraWorld.getPlateau().getZebraHero().setVitesseY(-1);
			}
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// On ne s'occupe pas des mouvements de souris
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// On ne s'occupe pas des scroll
		return false;
	}

}
