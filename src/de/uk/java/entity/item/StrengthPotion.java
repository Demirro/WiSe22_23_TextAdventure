package de.uk.java.entity.item;

import de.uk.java.entity.Entity;
import de.uk.java.entity.item.Potion;

public class StrengthPotion extends Potion {

	private int strengthBoost;
	
	public StrengthPotion(int strengthBoost) {
		this.strengthBoost = strengthBoost;
	}
	@Override
	public void useItem(Entity entity) {
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
