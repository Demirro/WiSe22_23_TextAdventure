package de.uk.java;

public class HealthPotion extends Potion {
	
	private int healValue;
	
	public HealthPotion(int healValue) {
		this.healValue = healValue;
	}

	@Override
	public void draw() {
		System.out.println("health potion");
		
	}

	@Override
	public void powerUp(Entity entity) {
		entity.setHealth(entity.getHealth() + healValue);
	}

	@Override
	public void getThrown(Entity entity) {
		powerUp(entity);
	}

}
