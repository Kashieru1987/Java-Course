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
