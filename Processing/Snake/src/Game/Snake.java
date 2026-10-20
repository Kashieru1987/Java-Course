package Game;

import Util.Cell;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    final List<Cell> positions;
    final int rgb;

    public Snake() {
        this.rgb = Settings.BLOCKS.SNAKE_COLOR.getRGB();
        this.positions = new ArrayList<Cell>();

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

}
