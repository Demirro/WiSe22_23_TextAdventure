package de.uk.java;

public class Player extends Entity{

	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Default constructor. Health is set to 100. Strength is set to 1.
	 */
	public Player() {
		super(100, 1);
	}
	
	/**
	 * Non-standard constructor. Give new player specific health and strength values
	 * @param health - int for health
	 * @param strength - int for strength
	 */
	public Player(int health, int strength) {
		super(health, strength);
	}
	
	public void usePotion(Potion potion) {
		potion.powerUp(this);
	}
	
	public void throw1(IThrowable throwable, Entity entity) {
		throwable.getThrown(entity);
	}
}
