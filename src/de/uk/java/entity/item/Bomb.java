package de.uk.java.entity.item;

import de.uk.java.entity.Entity;

public class Bomb extends Item implements IThrowable {
	
	private int explosionDamage = 20;
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}

	@Override
	public void useItem(Entity entity) {
		explode(entity);
	}

	@Override
	public void getThrown(Entity entity) {
		explode(entity);
	}
	private void explode(Entity entity) {
		entity.takeDamage(explosionDamage);
	}
}
