package fr.sam.core.world;

public class TileInfo {

	private int indexX;
	private int indexY;
	private float width;
	private float height;

	public TileInfo(int indexX, int indexY, float width, float height) {
		super();
		this.indexX = indexX;
		this.indexY = indexY;
		this.width = width;
		this.height = height;
	}

	// Getters et setters

	public int getIndexX() {
		return indexX;
	}

	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}

	public int getIndexY() {
		return indexY;
	}

	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
