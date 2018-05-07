package fr.sam;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class TiledMapReader {
	private OrthographicCamera camera;
	private World world;
	private MapObjects objects;
	public Array<Obstacle> obstacles;
	public Hero hero;

	public TiledMapReader(final Bomberman game, TiledMap tiledMap, World world, OrthographicCamera camera) {
		this.camera = camera;
		this.world = world;

		hero = new Hero(world, camera, tiledMap);

		objects = tiledMap.getLayers().get("Murs").getObjects();

		obstacles = new Array<Obstacle>();

		for (RectangleMapObject rectangleObject : objects.getByType(RectangleMapObject.class)) {
			Obstacle obstacle = new Obstacle(world, camera, rectangleObject);
			obstacles.add(obstacle);
		}
	}
}
