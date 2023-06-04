package de.uk.java.entity;

import de.uk.java.GameConfiguration;
import de.uk.java.entity.enemies.Enemy;
import de.uk.java.entity.item.Item;
import de.uk.java.utils.Printer;
import de.uk.java.utils.RandomNumberGenerator;

import java.io.Serializable;

public class Player extends Entity implements Serializable {

	private String name;
	private Inventory inventory;

	private int x;
	private int y;
	

	public Inventory getInventory() {
		return inventory;
	}

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
		super(GameConfiguration.PLAYER_HEALTH, GameConfiguration.PLAYER_HEALTH, GameConfiguration.PLAYER_STRENGTH, GameConfiguration.PLAYER_DEFENSE);
		inventory = new Inventory();
		x = 0;
		y = 0;
	}
	
	/**
	 * Non-standard constructor. Give new player specific health and strength values
	 * @param health - int for health
	 * @param strength - int for strength
	 */
	public Player(int health, int maxHealth, int strength, int defense) {
		super(health, maxHealth, strength, defense);
		inventory = new Inventory();
		x = 0;
		y = 0;
	}
	
	public Player(String name, int health, int maxHealth, int strength, int defense) {
		super(health, maxHealth, strength, defense);
		inventory = new Inventory();
		this.name = name;
		x = 0;
		y = 0;
	}

	public void attack(Enemy enemy) {
		int damage = RandomNumberGenerator.getRndInteger(getStrength()/2, getStrength())-(enemy.getDefense()/2);
		damage = (damage > 0) ? damage : 0;
		enemy.setHealth(enemy.getHealth()-damage);
		Printer.println("You attacked the " + enemy.getName() + ". You hit with " + damage + " damage.",GameConfiguration.TEXT_DELAY_MS);
	}

	public void moveLeft() {
		setX(x - 1);
	}

	public void moveRight() {
		setX(x + 1);
	}

	public void moveUp() {
		setY(y - 1);
	}

	public void moveDown() {
		setY(y + 1);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x >= 0 && x < GameConfiguration.DUNGEON_WIDTH) {
			this.x = x;
		}

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y >= 0 && y < GameConfiguration.DUNGEON_HEIGHT) {
			this.y = y;
		}
	}

	public void pickUp(Item item) {
		item.useItem(this);
	}

	public boolean escape(Enemy enemy) {
		return true;
	}

	public void drawHealth() {
		System.out.print("Player:     ");
		int heartsLeft = 0;
		for (int i = 0; i < getHealth(); i++) {
			if(i % 10 == 0) {
				heartsLeft++;
				System.out.print('\u2665');
			}
		}
		for (int i = 0; i < (getMaxHealth()/10) -heartsLeft; i++) {
			System.out.print('\u2661');
		}

		System.out.println();
	}

	public void defend(Enemy enemy) {

	}
}
