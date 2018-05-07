package fr.sam;

import com.badlogic.gdx.Gdx;

public class GameConstants {
	// World constants
	public static float MPP = 0.05f; // Meter/Pixel
	public static float PPM = 1 / MPP; // Pixel/Meter
	public static float BOX_STEP = 1 / 60f;
	public static int BOX_VELOCITY_ITERATIONS = 6;
	public static int BOX_POSITION_ITERATIONS = 2;
	public static float GRAVITY = 0;
	public static float DENSITY = 1.0f;

	// Tiled Map constants
	public static int PPT = 32; // Pixel/Tile

	// Screen constants
	public static int NB_HORIZONTAL_TILE = 50;
	public static float SCREEN_WIDTH = MPP * NB_HORIZONTAL_TILE * PPT;
	public static float SCREEN_RATIO = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
	public static float SCREEN_HEIGHT = SCREEN_WIDTH * SCREEN_RATIO;

	// Hero constants
	public static float HERO_HEIGHT = 1.5f * PPT * MPP / 2;
	public static float HERO_WIDTH = HERO_HEIGHT / 2;
	public static float JETPACK_IMPULSE = 100;
	public static float TOM_ROTATION = 5;
}
