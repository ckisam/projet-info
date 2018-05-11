package fr.sam.core.world;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class ZebraSprite extends Sprite implements IRenderable {

	protected ZebraWorld zebraWorld;
	private TileInfo tileInfo;

	// Vieilles choses, a supprimer ulterieurement au besoin
	private BodyDef bodyDef;
	protected Body body;
	private FixtureDef fixtureDef;
	private Fixture fixture;

	public ZebraSprite(ZebraWorld zebraWorld, TileInfo tileInfo, TextureRegion region) {
		super(region);
		this.zebraWorld = zebraWorld;
		this.tileInfo = tileInfo;
		updatePosition();
		createBody();
	}

	protected void updatePosition() {
		float newX = ((float) tileInfo.getIndexX()) * tileInfo.getWidth();
		float newY = ((float) tileInfo.getIndexY()) * tileInfo.getHeight();
		this.setPosition(newX, newY);
	}

	private void createBody() {
		PolygonShape polygonShape = new PolygonShape();
		// polygonShape.setAsBox(this.width, this.height);
		// polygonShape.setAsBox(getWidth() / 2, getHeight() / 2);
		polygonShape.setAsBox((getWidth() / 2) - 1, (getHeight() / 2) - 1);
		bodyDef = new BodyDef();
		// bodyDef.position.set(new Vector2(this.x, this.y));
		bodyDef.position.set(new Vector2(getX() + getWidth() / 2, getY() + getHeight() / 2));
		bodyDef.type = BodyType.StaticBody;
		body = zebraWorld.getWorld().createBody(bodyDef);
		fixtureDef = new FixtureDef();
		fixtureDef.shape = polygonShape;
		fixture = body.createFixture(fixtureDef);
		fixture.setUserData(EZebraSpriteType.getUserData(this));
		body.setUserData(EZebraSpriteType.getUserData(this));
		polygonShape.dispose();
	}

	protected BodyType getBodyType() {
		return BodyType.StaticBody;
	}

	@Override
	public void render(Batch batch) {
		this.draw(batch);
	}

	// Getters et setters

	public Body getBody() {
		return this.body;
	}

	public int getIndexX() {
		return tileInfo.getIndexX();
	}

	public void setIndexX(int indexX) {
		tileInfo.setIndexX(indexX);
		;
	}

	public int getIndexY() {
		return tileInfo.getIndexY();
	}

	public void setIndexY(int indexY) {
		tileInfo.setIndexY(indexY);
	}

}
