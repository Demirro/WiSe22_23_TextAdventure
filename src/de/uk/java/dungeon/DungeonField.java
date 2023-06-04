package de.uk.java.dungeon;

public class DungeonField {
    private DungeonFieldState state;

    private int x;
    private int y;


    /**
     * Generates a new Field with random FieldState property
     * @param x  x-coordinate
     * @param y  y-coordinate
     */
    public DungeonField(int x, int y) {
        state = new DungeonFieldState();
        setX(x);
        setY(y);
    }

    /**
     *
     * @param x
     * @param y
     * @param state the state
     */
    public DungeonField(int x, int y, DungeonFieldState state) {
        this.state = (state != null) ? state : new DungeonFieldState();
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DungeonFieldState getState() {
        return state;
    }

    public void setVisited() {
        state.setVisited();
    }

}
