package Game;

import Util.Cell;
import Util.Directions;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private final List<Cell> positions;
    private final int rgb;
    private Directions direction;

    public Snake() {
        this.rgb = Settings.BLOCKS.SNAKE_COLOR.getRGB();
        this.positions = new ArrayList<Cell>();
        this.direction = Directions.EAST;

        this.initSnakePositions();
    }

    private void initSnakePositions() {
        final int wide = Settings.BLOCKS.COUNT_WIDE;
        final int high = Settings.BLOCKS.COUNT_WIDE;
        final int x = wide/2;
        final int y = high/2;

        positions.add(new Cell(x, y, rgb));
        positions.add(new Cell(x-1, y, rgb));
        positions.add(new Cell(x-2, y, rgb));
    }

    public void updateSnake() {
        moveSnake();
        checkCollisions();
    }

    private void moveSnake() {
        int deltaX = 0;
        int deltaY = 0;
        switch(direction) {
            case NORTH -> deltaY--;
            case EAST -> deltaX++;
            case SOUTH -> deltaY++;
            case WEST -> deltaX--;
        }
        for(int i = positions.size()-1; i > 0; i--) {
            positions.set(i, positions.get(i-1));
        }
        final Cell previous = positions.getFirst();
        final int lastX = previous.getColumn();
        final int lastY = previous.getRow();
        positions.set(0, new Cell(lastX + deltaX, lastY + deltaY, rgb));
    }

    public void checkCollisions() {
    }

    public List<Cell> getPositions() {
        return this.positions;
    }

    public Directions getDirection() {
        return this.direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
        System.out.println("Direction set to " + direction);
    }

}
