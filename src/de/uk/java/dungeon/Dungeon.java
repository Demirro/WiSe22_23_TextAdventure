package de.uk.java.dungeon;

import de.uk.java.GameConfiguration;
import de.uk.java.entity.Player;
import de.uk.java.entity.enemies.Enemy;
import de.uk.java.entity.item.Item;
import de.uk.java.utils.Printer;

public class Dungeon {

    private DungeonField[][] map;
    private Player player;

    public Dungeon(int width, int height, Player player) {
        this.player = player;
        map = new DungeonField[height][width];
        initField();
    }

    public Dungeon(Player player) {
        this.player = player;
        map = new DungeonField[GameConfiguration.DUNGEON_HEIGHT][GameConfiguration.DUNGEON_WIDTH];
        initField();
    }

    public DungeonField getFieldAt(int x, int y) {
        return map[y][x];
    }


    public void setFieldAt(int x, int y, DungeonField field) {
        map[y][x] = field;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    public void drawWithoutTopClear() {

        // Draw top wall
        System.out.print(".–");
        for (int i = 0; i < GameConfiguration.DUNGEON_WIDTH; i++) {
            System.out.print("––");
        }
        System.out.print(".");
        System.out.println();

        for (int y = 0; y < map.length; y++) {
            System.out.print("|");
            for (int x = 0; x < map[y].length; x++) {
                DungeonField current = map[y][x];
                if(y == player.getY() && x == player.getX()) {
                    System.out.print(" X");
//					System.out.print("  ");
                } else if (current.getState().getContent() instanceof Item) {
                    System.out.print(" o");
//					System.out.print("  ");

                } else if (current.getState().getContent() instanceof Enemy) {
                    System.out.print(" +");
//					System.out.print("  ");

                } else {
//					System.out.print("  ");

                    System.out.print(" -");
                }
            }
            System.out.print(" |");
            System.out.println();
        }

        // Draw bottom wall
        System.out.print("*–");
        for (int i = 0; i < GameConfiguration.DUNGEON_WIDTH; i++) {
            System.out.print("––");
        }
        System.out.print("*");
        System.out.println();
    }

    public void draw(String message) {
        System.out.println("\n\n\n\n\n");
        Printer.println(message,GameConfiguration.TEXT_DELAY_MS);

        drawWithoutTopClear();
    }

    public void draw() {
        draw("");
    }

    private void initField() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
//				map[i][j] = new DungeonField(i, j,new DungeonFieldState(1));
                map[i][j] = new DungeonField(i, j);

            }
        }
        map[0][0].setVisited();
    }
}
