package de.uk.java.entity.enemies;

import de.uk.java.entity.Player;
import de.uk.java.entity.item.IThrowable;
import de.uk.java.entity.Entity;
import de.uk.java.utils.JSONReader;
import de.uk.java.utils.RandomNumberGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Ork extends Enemy {
	private String name;
	/**
	 * Default constructor. Health is set to 100. Strength is set to 1.
	 */
	public Ork() {
		super(10, 10, 2, 2);
		generateName();
	}

	/**
	 * Non-standard constructor. Give new ork specific health and strength values
	 * @param health - int for health
	 * @param strength - int for strength
	 */
	public Ork(int health, int maxHealth, int strength, int defense) {
		super(health, maxHealth, strength, defense);
		generateName();
	}

	private void generateName() {
		ArrayList<String> nameList = JSONReader.readName("Orc");
		Random rand = new Random();
		name = nameList.get(rand.nextInt(nameList.size()));
	}

	@Override
	public void specialSkill() {

	}

	@Override
	public void draw() {
		System.out.println("                   __\n" +
				"             w  c(..)o   (\n" +
				"              \\__(-)    __)\n" +
				"                   /\\   (\n" +
				"                  /(_)___)\n" +
				"                 w  /|\n" +
				"                 |\\/ |\n" +
				"                 m  m\n");
	}

	@Override
	public void action(Player player, boolean playerIsInDefense) {
		int damage = RandomNumberGenerator.getRndInteger(getStrength()/2, getStrength())-player.getDefense();
		damage = (damage > 0) ? damage : 0;
		System.out.printf("The Orc %s attacks you! You've taken %d damage", getName(), damage);
		player.setHealth(player.getHealth()-damage);
	}

	@Override
	public String getName() {
		return name;
	}
}
