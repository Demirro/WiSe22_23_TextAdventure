package de.uk.java;

public abstract class Entity {
	private int health;
	private int strength;
	
	public Entity(int health, int strength) {
		this.health = health;
		this.strength = strength;
	}
	
	public void takeDamage(int damageTaken) {
		if (damageTaken > 0) {
			health -= damageTaken;
		} else {
			System.err.println("Damage must be a positive integer");
		}
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
}
