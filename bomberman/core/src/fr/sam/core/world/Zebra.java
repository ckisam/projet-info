package fr.sam.core.world;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Zebra extends ZebraSprite {

	private static final int UPDATE_DELAY = 100;
	private static final int NB_STEP = 4;

	private volatile long nanoTime = System.nanoTime();
	private int verStep = 0, horStep = 0;
	private int vitesseX, vitesseY;

	public Zebra(ZebraWorld zebraWorld, TileInfo tileInfo, TextureRegion region) {
		super(zebraWorld, tileInfo, region);
	}

	@Override
	protected void updatePosition() {
		float xStep = ((float) horStep) / ((float) NB_STEP);
		float yStep = ((float) verStep) / ((float) NB_STEP);
		float newX = (((float) getIndexX()) + xStep) * getWidth();
		float newY = (((float) getIndexY()) + yStep) * getHeight();
		this.setPosition(newX, newY);
	}

	@Override
	protected BodyType getBodyType() {
		return BodyType.DynamicBody;
	}

	@Override
	public void render(Batch batch) {
		move();
		super.render(batch);
	}

	private synchronized void move() {
		long timeDiff = System.nanoTime() - nanoTime;
		if (TimeUnit.MILLISECONDS.convert(timeDiff, TimeUnit.NANOSECONDS) > UPDATE_DELAY) {
			if (!(vitesseX == 0 && vitesseY == 0)) {
				boolean left = vitesseX < 0 && canMoveLeft();
				boolean right = vitesseX > 0 && canMoveRight();
				boolean up = vitesseY > 0 && canMoveUp();
				boolean down = vitesseY < 0 && canMoveDown();
				if (left) {
					moveLeft();
				}
				if (right) {
					moveRight();
				}
				if (up) {
					moveUp();
				}
				if (down) {
					moveDown();
				}
				updatePosition();
			}
			nanoTime = System.nanoTime();
		}
	}

	private boolean canMoveLeft() {
		int xIndex = getIndexX();
		if (horStep == 0) {
			xIndex -= 1;
		}
		boolean res = this.zebraWorld.getWorldElementTab()[xIndex][getIndexY()] == null;
		if (verStep != 0) {
			res &= this.zebraWorld.getWorldElementTab()[xIndex][getIndexY() + 1] == null;
		}
		return res;
	}

	private boolean canMoveRight() {
		boolean res = this.zebraWorld.getWorldElementTab()[getIndexX() + 1][getIndexY()] == null;
		if (verStep != 0) {
			res &= this.zebraWorld.getWorldElementTab()[getIndexX() + 1][getIndexY() + 1] == null;
		}
		return res;
	}

	private boolean canMoveUp() {
		boolean res = this.zebraWorld.getWorldElementTab()[getIndexX()][getIndexY() + 1] == null;
		if (horStep != 0) {
			res &= this.zebraWorld.getWorldElementTab()[getIndexX() + 1][getIndexY() + 1] == null;
		}
		return res;
	}

	private boolean canMoveDown() {
		int yIndex = getIndexY();
		if (verStep == 0) {
			yIndex -= 1;
		}
		boolean res = this.zebraWorld.getWorldElementTab()[getIndexX()][yIndex] == null;
		if (horStep == 0) {
			res &= this.zebraWorld.getWorldElementTab()[getIndexX() + 1][yIndex] == null;
		}
		return res;
	}

	private void moveLeft() {
		if (horStep == 0) {
			horStep = NB_STEP - 1;
			setIndexX(getIndexX() - 1);
		} else {
			horStep -= 1;
		}
	}

	private void moveRight() {
		if (horStep == NB_STEP - 1) {
			horStep = 0;
			setIndexX(getIndexX() + 1);
		} else {
			horStep += 1;
		}
	}

	private void moveUp() {
		if (verStep == NB_STEP - 1) {
			verStep = 0;
			setIndexY(getIndexY() + 1);
		} else {
			verStep += 1;
		}
	}

	private void moveDown() {
		if (verStep == 0) {
			verStep = NB_STEP - 1;
			setIndexY(getIndexY() - 1);
		} else {
			verStep -= 1;
		}
	}

	// Getters et setters

	public int getVitesseX() {
		return vitesseX;
	}

	public void setVitesseX(int vitesseX) {
		this.vitesseX = vitesseX;
	}

	public int getVitesseY() {
		return vitesseY;
	}

	public void setVitesseY(int vitesseY) {
		this.vitesseY = vitesseY;
	}

}
