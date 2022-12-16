package de.uk.java;

public class StrengthPotion extends Potion {

	private int strengthBoost;
	
	public StrengthPotion(int strengthBoost) {
		this.strengthBoost = strengthBoost;
	}
	@Override
	public void powerUp(Entity entity) {
		entity.setStrength(entity.getStrength() + strengthBoost);
		
	}

	@Override
	public void draw() {
	}
	@Override
	public void getThrown(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
