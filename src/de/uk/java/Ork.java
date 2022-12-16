package de.uk.java;

import java.util.Random;

public class Ork extends Entity implements IThrowable {
	
	private int level;
	
	/**
	 * Default constructor. Health is set to 100. Strength is set to 1.
	 */
	public Ork() {
		super(10, 2);
	}
	
	/**
	 * Non-standard constructor. Give new ork specific health and strength values
	 * @param health - int for health
	 * @param strength - int for strength
	 */
	public Ork(int health, int strength) {
		super(health, strength);
	}
	
	
	public Ork(int playerStrength) {
		super(10, 0);
		double decider = Math.random();
		super.setStrength(decider >= 0.5 ? decider >= 0.75 ? playerStrength - 1 : playerStrength
				: decider <= 0.25 ? playerStrength + 2 : playerStrength + 1);
	}
	
	public Ork(short level) {
		super(0, 0);
		this.level = level;
		Random random = new Random();
		super.setHealth((random.nextInt((10 - 1) + 1) + 1 ) * level);
		super.setStrength((random.nextInt((5 - 1) + 1) + 1 ) * level);
	}

	@Override
	public void getThrown(Entity entity) {
		takeDamage(10);
	}
	
	

}
