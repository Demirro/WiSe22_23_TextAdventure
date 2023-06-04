package de.uk.java.dungeon;

import de.uk.java.entity.enemies.Enemy;
import de.uk.java.entity.enemies.Ork;
import de.uk.java.entity.item.HealthPotion;
import de.uk.java.entity.item.Item;
import de.uk.java.entity.item.StrengthPotion;
import de.uk.java.utils.RandomNumberGenerator;

import java.util.Random;

public class DungeonFieldState {

    private Item item;
    private Enemy enemy;


    /**
     * Random FieldState
     */
    public DungeonFieldState() {

        int rnd = RandomNumberGenerator.getRndInteger(1, 1000);

        int state = 1;
        if (rnd > 900) {
            state = 2;
        } else if (rnd > 800) {
            state = 3;
        }

        init(state);
    }

    /**
     * 1 - generates empty field 2 - generates item 3 - generates enemy
     *
     * @param state has to be 1,2 or 3
     */
    public DungeonFieldState(int state) {
        init(state);
    }

    public Object getContent() {
        if (item != null) {
            return item;
        } else if (enemy != null) {
            return enemy;
        } else {
            return null;
        }
    }


    private void init(int state) {
        switch (state) {
            case 1:
                break;
            case 2:
                item = getRandomItem();
            case 3:
                enemy = getRandomEnemy();
            default:
                break;
        }
    }

    private Enemy getRandomEnemy() {

        int rnd = RandomNumberGenerator.getRndInteger(1, 3);

        switch (rnd) {
            case 1:
                return new Ork();
            default:
                return new Ork();
        }
    }



    private Item getRandomItem() {

        int rnd = RandomNumberGenerator.getRndInteger(1, 2);

        switch (rnd) {
            case 1:
                return new StrengthPotion(RandomNumberGenerator.getRndInteger(1, 10));
            case 2:
                return new HealthPotion(RandomNumberGenerator.getRndInteger(1, 10));
            default:
                return new HealthPotion(RandomNumberGenerator.getRndInteger(1, 10));
        }

    }

    public void setVisited() {
        item = null;
        enemy = null;

    }
}
