package de.uk.java.entity.enemies;

import de.uk.java.entity.Entity;
import de.uk.java.entity.Player;

public abstract class Enemy extends Entity {

    public Enemy(int health, int maxHealth, int strength, int defense) {
        super(health, maxHealth, strength, defense);
    }
    public abstract void specialSkill();
    public abstract void draw();
    public abstract void action(Player player, boolean playerIsInDefense);

    public abstract String getName();
}
