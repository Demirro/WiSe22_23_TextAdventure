/**
 * 
 */
package de.uk.java;

/**
 * @author Théo Bouveyron
 *
 */
public class Player {
	private int health;
	private int strength;
	private String name;
	
	public Player(int health, int strength) {
		this.health = health;
		this.strength = strength;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
	
	public void takeDamage(int damage) {
		health -= damage;
	}
}
