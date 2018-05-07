package fr.sam;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Obstacle {

	public Body body;
	protected BodyDef bodyDef;
	protected FixtureDef fixtureDef;
	protected PolygonShape polygonShape;
	public float posX, posY, width, height, angle;
	Camera camera;

	public Obstacle(World world, Camera camera, MapObject rectangleObject) {
		create(world, camera, rectangleObject);
	}

	public void create(World world, Camera camera, MapObject rectangleObject) {

		Rectangle rectangle = ((RectangleMapObject) rectangleObject).getRectangle();

		this.camera = camera;
		this.posX = (rectangle.x + rectangle.width / 2) * GameConstants.MPP;
		this.posY = (rectangle.y + rectangle.height / 2) * GameConstants.MPP;
		this.width = (rectangle.width / 2) * GameConstants.MPP;
		this.height = (rectangle.height / 2) * GameConstants.MPP;

		if (rectangleObject.getProperties().get("rotation") != null)
			this.angle = -Float.parseFloat(rectangleObject.getProperties().get("rotation").toString())
					* MathUtils.degreesToRadians;

		polygonShape = new PolygonShape();
		polygonShape.setAsBox(width, height);

		bodyDef = new BodyDef();
		bodyDef.position.set(new Vector2(posX, posY));
		bodyDef.type = getBodyType();
		body = world.createBody(bodyDef);

		fixtureDef = new FixtureDef();
		fixtureDef.shape = polygonShape;
		fixtureDef.density = (float) (GameConstants.DENSITY / (width * height));
		fixtureDef.friction = 0.5f;
		fixtureDef.restitution = 0.5f;

		body.createFixture(fixtureDef).setUserData("Obstacle");
		body.setUserData("Obstacle");

		if (rectangleObject.getProperties().get("rotation") != null) {
			/*
			 * To obtain x' et y' positions from x et y positions after a rotation of an
			 * angle A around the origine (0, 0) : x' = x*cos(A) - y*sin(A) y' = x*sin(A) +
			 * y*cos(A)
			 */
			float X = (float) (body.getPosition().x - width + width * Math.cos(angle) + height * Math.sin(angle));
			float Y = (float) (width * Math.sin(angle) + body.getPosition().y + height - height * Math.cos(angle));
			body.setTransform(X, Y, this.angle);
		}

		polygonShape.dispose();
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getX() {
		return posX;
	}

	public float getY() {
		return posY;
	}

	public void setX(float X) {
		posX = X;
	}

	public void setY(float Y) {
		posY = Y;
	}

	public void active() {
	}

	public BodyType getBodyType() {
		return BodyType.StaticBody;
	}

}
