/**
 * 
 */
package de.uk.java;

/**
 * @author Théo Bouveyron
 *
 */
public class Enemy {
	private int health;
	private int strength;
	
	public Enemy(int health, int strength) {
		this.health = health;
		this.strength = strength;
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
