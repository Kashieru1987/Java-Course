package Util;

import Game.Settings;

public class Cell {
    private final int column;
    private final int row;
    private final int rgb;

    public Cell(int column, int row) {
        this(column, row, Settings.BLOCKS.BACKGROUND_COLOR.getRGB());
    }

    public Cell(int column, int row, int rgb) {
        this.column = column;
        this.row = row;
        this.rgb = rgb;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    public int getRGB() {
        return this.rgb;
    }

}
