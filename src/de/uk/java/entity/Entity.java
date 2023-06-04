package de.uk.java.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	private int health;
	private int maxHealth;
	private int strength;
	private int defense;
	
	public Entity(int health, int maxHealth, int strength, int defense) {
		this.health = health;
		this.maxHealth = maxHealth;
		this.strength = strength;
		this.defense = defense;
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

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}
