package fr.sam.core.world.cellule;

import com.badlogic.gdx.graphics.g2d.Batch;

import fr.sam.core.world.ZebraSprite;

public class Bonus extends ZebraSprite {

	private EBonus type;

	public Bonus(ZebraCellule cellule, EBonus type) {
		super(type.getTexture());
		this.type = type;
		setPosition(cellule.getX(), cellule.getY());
	}

	@Override
	public void render(Batch batch) {
		this.draw(batch);
	}

	// Getters et setters

	public EBonus getType() {
		return type;
	}

	public void setType(EBonus type) {
		this.type = type;
	}

}
