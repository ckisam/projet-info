package fr.sam;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Hero {

	public Body heroBody;
	private BodyDef bodyDef;
	private FixtureDef fixtureDef;
	private PolygonShape heroShape;
	private float width, height, posXInit, posYInit;
	private Vector2 direction;

	public Hero(World world, Camera camera, TiledMap tiledMap) {

		MapObjects personnages = (MapObjects) tiledMap.getLayers().get("Personnage").getObjects();
		System.out.println(tiledMap.getLayers().get("Personnage"));
		System.out.println(personnages);
		System.out.println(personnages.get("Tom"));

		width = GameConstants.HERO_WIDTH;
		height = GameConstants.HERO_HEIGHT;
		// posXInit = (personnages.get("Tom").getProperties().get("x", float.class)
		// + personnages.get("Tom").getProperties().get("width", float.class) / 2) *
		// GameConstants.MPP;
		// posYInit = (personnages.get("Tom").getProperties().get("y", float.class)
		// + personnages.get("Tom").getProperties().get("height", float.class) / 2) *
		// GameConstants.MPP;
		// direction = new Vector2();
		posXInit = 0;
		posYInit = 0;
		direction = new Vector2();

		heroShape = new PolygonShape();
		heroShape.setAsBox(width, height);

		bodyDef = new BodyDef();
		bodyDef.position.set(posXInit, posYInit);
		bodyDef.type = BodyType.DynamicBody;

		heroBody = world.createBody(bodyDef);
		heroBody.setFixedRotation(false);

		fixtureDef = new FixtureDef();
		fixtureDef.shape = heroShape;
		fixtureDef.density = (float) (GameConstants.DENSITY / (width * height));
		fixtureDef.friction = 0.01f;
		fixtureDef.restitution = 0.1f;
		heroBody.createFixture(fixtureDef).setUserData("Tom");
		heroBody.setUserData("Tom");

		heroShape.dispose();
	}

	public void displacement() {
		if (Gdx.input.isKeyPressed(Keys.W)) {
			heroBody.applyForceToCenter(new Vector2(0, GameConstants.JETPACK_IMPULSE)
					.rotate(heroBody.getAngle() * MathUtils.radiansToDegrees), true);
		}

		if (Gdx.input.isKeyPressed(Keys.A))
			heroBody.setAngularVelocity(GameConstants.TOM_ROTATION);
		else if (Gdx.input.isKeyPressed(Keys.D))
			heroBody.setAngularVelocity(-GameConstants.TOM_ROTATION);
		else
			heroBody.setAngularVelocity(0);
	}

	public float getX() {
		return heroBody.getPosition().x;
	}

	public float getY() {
		return heroBody.getPosition().y;
	}

	public Vector2 getOrigine() {
		return new Vector2(posXInit, posYInit);
	}

}
