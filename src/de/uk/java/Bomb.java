package de.uk.java;

public class Bomb extends Item implements IThrowable{
	
	private int explosionDamage = 20;
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
	}

	@Override
	public void getThrown(Entity entity) {
		explode(entity);
	}
	
	public void explode(Entity entity) {
		entity.takeDamage(explosionDamage);
	}

}
